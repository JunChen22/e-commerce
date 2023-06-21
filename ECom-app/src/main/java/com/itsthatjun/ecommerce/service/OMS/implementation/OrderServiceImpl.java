package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.config.PaypalPaymentIntent;
import com.itsthatjun.ecommerce.config.PaypalPaymentMethod;
import com.itsthatjun.ecommerce.dto.OMS.ConfirmOrderResult;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.exceptions.OMS.OrderException;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
import com.itsthatjun.ecommerce.service.PaypalService;
import com.itsthatjun.ecommerce.service.SMS.implementation.CouponServiceImpl;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MemberService memberService;

    @Autowired
    private CouponServiceImpl couponService;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private ReceiveAddressMapper addressMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CartItemServiceImpl cartItemService;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ProductSkuStockMapper stockMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ConfirmOrderResult generateCartItem(List<CartItem> cartItems, String couponCode) {
        Member currMember = memberService.getCurrentUser();
        ConfirmOrderResult result = new ConfirmOrderResult();
        result.setCartItemList(cartItems);

        List<Integer> cartItemIds = new ArrayList<>();
        double totalPrice = 0;
        for (CartItem item : cartItems) {
            cartItemIds.add(item.getProductId());
            totalPrice += item.getPrice().doubleValue();
        }

        result.setTotalPrice(totalPrice);

        if (couponService.checkCoupon(couponCode) != null){
            result.setCoupon(couponCode);
        }

        double discountedAmount = calculateCouponDiscount(cartItemIds, couponCode);
        result.setCouponDiscount(discountedAmount);

        // check shipping cost, $50 or more get free shipping or $15
        ReceiveAddressExample addressExample = new ReceiveAddressExample();
        addressExample.createCriteria().andMemberIdEqualTo(currMember.getId());
        ReceiveAddress address = addressMapper.selectByExample(addressExample).get(0);
        // TODO: calculate shipping cost from UPS API, currently just fixed rate
        result.setAddress(address);
        double shippingCost = 15;  // default shipping cost before UPS check
        if (result.getTotalPrice() > 50) {
            shippingCost = 0;
        }

        result.setPayAmount(totalPrice - discountedAmount + shippingCost);

        return result;
    }

    // TODO: change if these coupons are for one time or all that fits, like $15 off twice
    // TODO: and check if coupon is active/status
    private double calculateCouponDiscount(List<Integer> productIds, String couponCode) {
        double discountAmount = 0;
        Coupon coupon = couponService.checkCoupon(couponCode);
        if (coupon == null) return discountAmount;

        // TODO: fix the discount amount with different coupon like for all item, brand, total off and etc
        // TODO: to check fixed amount of coupon available
        for (int productId : productIds) {
            List<Coupon> couponList = couponService.getCouponForProduct(productId);
            for (Coupon c : couponList) {
                if (c.getCode().equals(coupon.getCode())) {
                    discountAmount += coupon.getAmount().doubleValue();
                }
            }
        }
        return discountAmount;
    }

    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam, String successUrl, String cancelUrl) {
        // get user from JWT token context
        Member currentMember = memberService.getCurrentUser();

        List<OrderItem> orderItemList = new ArrayList<>();
        String couponCode = orderParam.getCoupon();
        ReceiveAddress receiveAddress = orderParam.getAddress();
        double price = 0;
        double couponDiscount = 0;
        double shippingCost = 15;  // default shipping cost before UPS check

        for (CartItem item : orderParam.getCartItemList()) {
            // generate order item information
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(item.getProductId());
            orderItem.setProductName(item.getProductName());
            orderItem.setProductQuantity(item.getQuantity());
            orderItem.setProductSkuCode(item.getProductSku());

            ProductSkuStockExample skuStockExample = new ProductSkuStockExample();
            skuStockExample.createCriteria().andProductIdEqualTo(orderItem.getProductId())
                                            .andSkuCodeEqualTo(orderItem.getProductSkuCode());
            price += stockMapper.selectByExample(skuStockExample).get(0).getPromotionPrice().doubleValue() * item.getQuantity();

            orderItemList.add(orderItem);
        }

        if (!hasStock(orderItemList)) {
            throw new OrderException("Not enough stock, Unable to order");
        }
        lockStock(orderItemList);

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(couponCode);
        Coupon foundCoupon = couponMapper.selectByExample(couponExample).size() > 0 ?
                                                couponMapper.selectByExample(couponExample).get(0) : null ;

        // whole order discount
        if (foundCoupon != null && foundCoupon.getCouponType() == 0) {
            if (foundCoupon.getDiscountType() == 0) {
                couponDiscount = foundCoupon.getAmount().doubleValue();
            } else {
                couponDiscount = (price * foundCoupon.getAmount().doubleValue())/100;
            }
        } else if (foundCoupon != null){
            // discount from product discount
            couponDiscount = couponService.getDiscountAmount(orderItemList, orderParam.getCoupon());
        }

        // calculate order price, shipping, promotion, coupon
        // check shipping cost, $50 or more get free shipping or $15
        // TODO: calculate shipping cost from UPS API, currently just fixed rate

        if (price > 50) shippingCost = 0;;

        price = price - couponDiscount + shippingCost;

        try {
            Payment payment = paypalService.createPayment(price, "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "payment description", cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    System.out.println( "redirect:" + links.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String cancelOrder(String orderSN) {
        //todo: cancel order
        Orders foundOrder = detail(orderSN);

        //  waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5

        if (foundOrder == null)
            return "can't cancel, order serial number don't exist";
        if (foundOrder.getStatus() >= 2) {
            return "Order already send out, can not cancel";
        }

        // TODO :might add something like need admin approval after certain hours to cancel order
        foundOrder.setStatus(5);

        ordersMapper.updateByPrimaryKeySelective(foundOrder);

        return "order cancelled: " + orderSN;
    }

    @Override
    public List<Orders> list(int status, int pageNum, int pageSize) {
        Member currentMember = memberService.getCurrentUser();

        PageHelper.startPage(pageNum, pageSize);
        OrdersExample ordersExample = new OrdersExample();
        // TODO: the status code. currently just return all
        ordersExample.createCriteria().andMemberIdEqualTo(currentMember.getId());

        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        return ordersList;
    }

    @Override
    public Orders detail(String orderSN) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSN);
        if (ordersMapper.selectByExample(ordersExample).size() > 0)
            return ordersMapper.selectByExample(ordersExample).get(0);
        return null;
    }

    // TODO: use a better way to generate order serial number
    private String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //String key = REDIS_DATABASE+":"+ REDIS_KEY_ORDER_ID + date;
        //Long increment = redisService.incr(key, 1);
        sb.append(date);
        sb.append("A BETTER WAY TO GENERATE SN");
        //sb.append(String.format("%02d", order.getSourceType()));
        //sb.append(String.format("%02d", order.getPayType()));
        //String incrementStr = increment.toString();
        //if (incrementStr.length() <= 6) {
        //    sb.append(String.format("%06d", increment));
        //} else {
        //    sb.append(incrementStr);
        //}
        return sb.toString();
    }

    private void lockStock(List<OrderItem> orderItemList) {

        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();
            ProductSkuStockExample example = new ProductSkuStockExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSkuStock itemStock = stockMapper.selectByExample(example).get(0);

            int itemStockNow = itemStock.getLockStock();

            itemStock.setLockStock(itemStockNow + quantityNeeded);
            stockMapper.updateByPrimaryKey(itemStock);
        }
    }

    private void unlockStock(List<OrderItem> orderItemList) {

        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();
            ProductSkuStockExample example = new ProductSkuStockExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSkuStock itemStock = stockMapper.selectByExample(example).get(0);

            int itemStockNow = itemStock.getStock();
            int itemStockLockNow = itemStock.getLockStock();


            itemStock.setStock(itemStockNow - quantityNeeded);
            itemStock.setLockStock(itemStockLockNow - quantityNeeded);
            stockMapper.updateByPrimaryKey(itemStock);
        }
    }

    private boolean hasStock(List<OrderItem> orderItemList) {

        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();
            ProductSkuStockExample example = new ProductSkuStockExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSkuStock itemStock = stockMapper.selectByExample(example).get(0);

            if (itemStock != null && itemStock.getStock() < (itemStock.getLockStock() + quantityNeeded)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Orders paySuccess(String couponCode, ReceiveAddress address) {

        Member currentMember = memberService.getCurrentUser();
        List<CartItem> cartItemList = cartItemService.getUserCart();
        List<OrderItem> orderItemList = new ArrayList<>();

        double preDiscount = 0;
        double price = 0;
        double couponDiscount = 0;
        double shippingCost = 15;  // default shipping cost before UPS check

        Orders newOrder = new Orders();

        for (CartItem item : cartItemList) {
            // generate order item information
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(item.getProductId());
            orderItem.setProductName(item.getProductName());
            orderItem.setProductQuantity(item.getQuantity());
            orderItem.setProductSkuCode(item.getProductSku());

            ProductSkuStockExample skuStockExample = new ProductSkuStockExample();
            skuStockExample.createCriteria().andProductIdEqualTo(orderItem.getProductId())
                    .andSkuCodeEqualTo(orderItem.getProductSkuCode());

            ProductSkuStock skuStock = stockMapper.selectByExample(skuStockExample).get(0);

            double skuProductPrice = skuStock.getPromotionPrice().doubleValue();
            orderItem.setProductPrice(BigDecimal.valueOf(skuProductPrice));
            price += skuProductPrice * item.getQuantity();
            preDiscount += skuStock.getPrice().doubleValue() * item.getQuantity();
            orderItemList.add(orderItem);
        }

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(couponCode);
        Coupon foundCoupon = couponMapper.selectByExample(couponExample).size() > 0 ?
                couponMapper.selectByExample(couponExample).get(0) : null ;

        // whole order discount
        if (foundCoupon != null && foundCoupon.getCouponType() == 0) {
            if (foundCoupon.getDiscountType() == 0) {
                couponDiscount = foundCoupon.getAmount().doubleValue();
            } else {
                couponDiscount = (price * foundCoupon.getAmount().doubleValue())/100;
            }
        } else if (foundCoupon != null){
            // discount from product discount
            couponDiscount = couponService.getDiscountAmount(orderItemList, couponCode);
        }

        // calculate order price, shipping, promotion, coupon
        // check shipping cost, $50 or more get free shipping or $15
        // TODO: calculate shipping cost from UPS API, currently just fixed rate
        if (price > 50) shippingCost = 0;;

        price = price - couponDiscount + shippingCost;

        newOrder.setMemberId(currentMember.getId());
        String serialNumber = generateOrderSn();
        newOrder.setOrderSn(serialNumber);

        // payment infos
        newOrder.setTotalAmount(BigDecimal.valueOf(preDiscount));
        // TODO: add promotion_amount, might get dao, it's little complex for mapper
        // newOrder.setPromotionAmount();
        newOrder.setShippingCost(BigDecimal.valueOf(shippingCost));
        newOrder.setCouponAmount(BigDecimal.valueOf(couponDiscount));
        newOrder.setDiscountAmount(BigDecimal.valueOf(couponDiscount));
        //
        newOrder.setPayAmount(BigDecimal.valueOf(price + shippingCost - couponDiscount));

        newOrder.setStatus(1);


        // TODO: get it FROM UPS API
        newOrder.setDeliveryCompany("UPS");
        // String trackingNumber = UPSTracking(address);
        newOrder.setDeliveryTrackingNumber("TRACKING FROM UPS");

        // address/receiver infos
        newOrder.setReceiverName(address.getReceiverName());
        newOrder.setReceiverPhone(address.getPhoneNumber());
        newOrder.setReceiverDetailAddress(address.getDetailAddress());
        newOrder.setReceiverCity(address.getCity());
        newOrder.setReceiverState(address.getState());
        newOrder.setReceiverZipCode(address.getZipCode());

        Date currentTime = new Date();
        newOrder.setPaymentTime(currentTime);
        newOrder.setCreatedAt(currentTime);

        // add order to database
        ordersMapper.insertSelective(newOrder);

        for (OrderItem item: orderItemList) {
            // find product and get current stock and update it
            ProductExample productExample = new ProductExample();
            productExample.createCriteria().andIdEqualTo(item.getProductId());
            Product updateProduct = productMapper.selectByExample(productExample).get(0);

            int currentStock = updateProduct.getStock();
            updateProduct.setStock(currentStock - item.getProductQuantity());
            productMapper.updateByPrimaryKey(updateProduct);

            // insert the order item into database
            item.setOrderId(newOrder.getId());
            item.setOrderSn(serialNumber);
            item.setProductPrice(item.getProductPrice());
            orderItemMapper.insert(item);
        }

        // clear cart
        cartItemService.clearCartItem();
        // unlock stock
        unlockStock(orderItemList);
        // update coupon
        couponService.updateUsedCoupon(couponCode, newOrder.getId(), currentMember.getId());

        return newOrder;
    }

    @Override
    public void payFail() {
        Member currentMember = memberService.getCurrentUser();
        List<CartItem> cartItemList = cartItemService.getUserCart();
        List<OrderItem> orderItemList = new ArrayList<>();

        // free up locked stock
        for (CartItem item : cartItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSku();
            int quantityNeeded = item.getQuantity();
            ProductSkuStockExample example = new ProductSkuStockExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSkuStock itemStock = stockMapper.selectByExample(example).get(0);

            int itemStockLockNow = itemStock.getLockStock();

            itemStock.setLockStock(itemStockLockNow - quantityNeeded);
            stockMapper.updateByPrimaryKey(itemStock);
        }
    }
}
