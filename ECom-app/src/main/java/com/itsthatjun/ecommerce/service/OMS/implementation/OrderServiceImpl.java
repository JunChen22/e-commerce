package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.config.PaypalPaymentIntent;
import com.itsthatjun.ecommerce.config.PaypalPaymentMethod;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.exceptions.OMS.OrderException;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
import com.itsthatjun.ecommerce.service.PMS.implementation.ProductServiceImpl;
import com.itsthatjun.ecommerce.service.PaypalService;
import com.itsthatjun.ecommerce.service.SMS.implementation.CouponServiceImpl;
import com.itsthatjun.ecommerce.service.SMS.implementation.SalesServiceimpl;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final double SHIPPING_COST = 15;  // default shipping cost for order less than 50

    private final MemberService memberService;

    private final CouponServiceImpl couponService;

    private final ProductServiceImpl productService;        // TODO: update stock

    private final SalesServiceimpl salesServiceimpl;    // TODO: not used yet for when sales limit reached

    private final CartItemServiceImpl cartItemService;

    private final PaypalService paypalService;

    private final OrdersMapper ordersMapper;

    private final OrderItemMapper orderItemMapper;

    private final OrderChangeHistoryMapper orderChangeHistoryMapper;

    private final ProductMapper productMapper;

    private final ProductSkuMapper stockMapper;

    @Autowired
    public OrderServiceImpl(MemberService memberService, CouponServiceImpl couponService, ProductServiceImpl productService, SalesServiceimpl salesServiceimpl, CartItemServiceImpl cartItemService, PaypalService paypalService, OrdersMapper ordersMapper, OrderItemMapper orderItemMapper, OrderChangeHistoryMapper orderChangeHistoryMapper, ProductMapper productMapper, ProductSkuMapper stockMapper) {
        this.memberService = memberService;
        this.couponService = couponService;
        this.productService = productService;
        this.salesServiceimpl = salesServiceimpl;
        this.cartItemService = cartItemService;
        this.paypalService = paypalService;
        this.ordersMapper = ordersMapper;
        this.orderItemMapper = orderItemMapper;
        this.orderChangeHistoryMapper = orderChangeHistoryMapper;
        this.productMapper = productMapper;
        this.stockMapper = stockMapper;
    }

    @Override
    public Orders detail(String orderSN) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSN);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
        if (ordersList.isEmpty()) return null;
        return ordersMapper.selectByExample(ordersExample).get(0);
    }

    @Override
    public List<Orders> list(int status, int pageNum, int pageSize) {
        Member currentMember = memberService.getCurrentUser();
        int userId = currentMember.getId();

        PageHelper.startPage(pageNum, pageSize);
        OrdersExample ordersExample = new OrdersExample();
        // TODO: the status code. currently just return all
        ordersExample.createCriteria().andMemberIdEqualTo(userId);

        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
        if (ordersList.isEmpty()) return null;
        return ordersList;
    }

    @Override
    public Orders generateOrder(OrderParam orderParam, String successUrl, String cancelUrl) {

        // get user from JWT token context
        Member currentMember = memberService.getCurrentUser();
        int userId = currentMember.getId();

        String orderSn = generateOrderSn();
        String couponCode = orderParam.getCoupon();
        Address address = orderParam.getAddress();
        String payType = orderParam.getPayType();

        Orders newOrder = new Orders();
        List<OrderItem> orderItemList = new ArrayList<>();


        Map<String, Integer> skuQuantity = orderParam.getOrderProductSku(); // sku and quantity for order

        double orderTotal = 0;
        double couponDiscount = orderParam.getDiscountAmount();

        // verify the price again
        for (String productSku: skuQuantity.keySet()) {

            int quantity = orderParam.getOrderProductSku().get(productSku);

            // find the sku and product
            ProductSkuExample productSkuExample = new ProductSkuExample();
            productSkuExample.createCriteria().andSkuCodeEqualTo(productSku);
            ProductSku productSkuStock = stockMapper.selectByExample(productSkuExample).get(0);

            ProductExample productExample = new ProductExample();
            productExample.createCriteria().andIdEqualTo(productSkuStock.getProductId());
            Product product = productMapper.selectByExample(productExample).get(0);

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.getId());
            orderItem.setProductName(product.getName());
            orderItem.setProductQuantity(quantity);
            orderItem.setProductSkuCode(productSku);

            orderTotal += productSkuStock.getPromotionPrice().doubleValue() * quantity;
            orderItemList.add(orderItem);
        }

        if (!hasStock(orderItemList)) {
            throw new OrderException("Not enough stock, Unable to order");
        }

        orderTotal = Math.round(orderTotal * 100.0) / 100.0;  // TODO: change back double to big decimal for more accuracy
        // and use.setScale(2, RoundingMode.CEILING);

        // verify price difference
        if (orderTotal != orderParam.getAmount()) {
            throw new OrderException("Pricing error");
        }

        lockStock(orderItemList);

        // synchronous call to coupon service, assume the accepted discount amount is incorrect.
        double checkedDiscount = couponService.checkDiscount(couponCode);
        couponDiscount = couponDiscount == checkedDiscount ? couponDiscount : 0;

        // check shipping cost, $50 or more get free shipping or $15
        // TODO: calculate shipping cost from UPS API, currently just fixed rate
        if (orderTotal < 50) orderTotal += SHIPPING_COST;

        orderTotal = orderTotal - couponDiscount;

        //newOrder.setPayType(payType);  // TODO: change data type to string in database

        newOrder.setOrderSn(orderSn);
        newOrder.setStatus(0);   // waiting for payment
        newOrder.setTotalAmount(BigDecimal.valueOf(orderTotal));
        newOrder.setMemberId(userId);

        newOrder.setReceiverName(address.getReceiverName());
        newOrder.setReceiverDetailAddress(address.getDetailAddress());

        ordersMapper.insert(newOrder);

        int newOrderId = newOrder.getId();

        for (OrderItem item : orderItemList) {
            item.setOrderSn(orderSn);
            item.setOrderId(newOrderId);
            orderItemMapper.insert(item);
        }

        if (!couponCode.equals("")) couponService.updateUsedCoupon(couponCode,newOrderId );

        cartItemService.clearCartItem();
        updateChangeLog(newOrderId, 0, "generate order","user");

        try {
            Payment payment = paypalService.createPayment(orderTotal, "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "payment description", cancelUrl ,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    System.out.println("redirect:" + links.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            LOG.error(e.getMessage());
        }
        return newOrder;
    }

    @Override
    public Orders paySuccess(String orderSn, String paymentId, String payerId) {

        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                System.out.println("successful payment");

                // find and update the order, status, payment info
                OrdersExample ordersExample = new OrdersExample();
                ordersExample.createCriteria().andOrderSnEqualTo(orderSn);
                Orders foundOrder = ordersMapper.selectByExample(ordersExample).get(0);

                foundOrder.setStatus(1);  // waiting for payment 0 , fulfilling 1,
                foundOrder.setPaymentId(paymentId);
                foundOrder.setPayerId(payerId);
                foundOrder.setPayAmount(foundOrder.getTotalAmount());

                int orderId = foundOrder.getId();
                Date currentDate = new Date();
                foundOrder.setPaymentTime(currentDate);
                foundOrder.setUpdatedAt(currentDate);

                ordersMapper.updateByPrimaryKey(foundOrder);

                OrderItemExample orderItemExample = new OrderItemExample();
                orderItemExample.createCriteria().andOrderSnEqualTo(orderSn);
                List<OrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);

                Map<String, Integer> itemOrderQuantity = new HashMap<>();

                // update stock and free up locked stock
                for (OrderItem item: orderItemList) {
                    int quantityOrdered = item.getProductQuantity();;

                    // find product and get current stock and update it
                    ProductExample productExample = new ProductExample();
                    productExample.createCriteria().andIdEqualTo(item.getProductId());
                    Product product = productMapper.selectByExample(productExample).get(0);

                    int currentStock = product.getStock();
                    product.setStock(currentStock - quantityOrdered);
                    productMapper.updateByPrimaryKey(product);

                    // update sku stock and free lock stock
                    ProductSkuExample productSkuStockExample = new ProductSkuExample();
                    productSkuStockExample.createCriteria().andSkuCodeEqualTo(item.getProductSkuCode()).andProductIdEqualTo(product.getId());
                    ProductSku producutSku = stockMapper.selectByExample(productSkuStockExample).get(0);

                    currentStock = producutSku.getStock();
                    producutSku.setStock(currentStock - quantityOrdered);
                    producutSku.setLockStock(producutSku.getLockStock() - quantityOrdered);
                    stockMapper.updateByPrimaryKey(producutSku);
                }

                updateChangeLog(orderId, 1, "payment success","user");

                return foundOrder;
            }
        } catch (PayPalRESTException e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void payFail(String orderSn) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSn);
        Orders newOrder = ordersMapper.selectByExample(ordersExample).get(0);

        int orderId = newOrder.getId();

        OrderItemExample orderItemExample = new OrderItemExample();
        orderItemExample.createCriteria().andOrderSnEqualTo(orderSn).andOrderIdEqualTo(orderId);
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);

        Map<String, Integer> itemOrderQuantity = new HashMap<>();

        // free up locked stock
        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();

            ProductSkuExample example = new ProductSkuExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSku skuStock = stockMapper.selectByExample(example).get(0);

            int itemStockLockNow = skuStock.getLockStock();
            skuStock.setLockStock(itemStockLockNow - quantityNeeded);
            stockMapper.updateByPrimaryKey(skuStock);

            itemOrderQuantity.put(skuCode, quantityNeeded);
        }

        updateChangeLog(orderId, 5, "payment fail","user");
    }

    @Override
    public Orders cancelOrder(String orderSn) {

        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSn);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        if (ordersList.isEmpty()) {
            throw new RuntimeException("order not found with order serial number: " + orderSn); // TODO: create OrderNotFoundException
        }

        Orders foundOrder = ordersList.get(0);
        int orderId = foundOrder.getId();

        //  waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 , invalid 5
        int currentStatus = foundOrder.getStatus();

        if (currentStatus >= 2) {
            throw new OrderException("Order already send out, can not cancel");
        }

        // TODO :might add something like need admin approval after certain hours to cancel order
        OrderItemExample orderItemExample = new OrderItemExample();
        orderItemExample.createCriteria().andOrderSnEqualTo(orderSn);
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);

        Map<String, Integer> skuQuantity = new HashMap<>();

        // record order sku and quantity, and update OMS stock.
        for (OrderItem orderItem : orderItemList) {
            String skuCode = orderItem.getProductSkuCode();
            int quantity = orderItem.getProductQuantity();
            skuQuantity.put(skuCode, quantity);

            // update OMS stock, increase product and sku stock. same as return.
            ProductSkuExample skuStockExample = new ProductSkuExample();
            skuStockExample.createCriteria().andSkuCodeEqualTo(skuCode);
            ProductSku skuStock = stockMapper.selectByExample(skuStockExample).get(0);

            int currentStock = skuStock.getStock();

            skuStock.setStock(currentStock + quantity);
            stockMapper.updateByPrimaryKey(skuStock);
        }

        foundOrder.setStatus(5);
        ordersMapper.updateByPrimaryKeySelective(foundOrder);

        updateChangeLog(orderId, 5, "Cancel order","user");

        return foundOrder;
    }

    @Override
    public void confirmReceiveOrder(int orderId) {
        // TODO: with spring stask to check from UPS/FedEx for package delivery update.
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
            ProductSkuExample example = new ProductSkuExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSku itemStock = stockMapper.selectByExample(example).get(0);

            int itemStockNow = itemStock.getLockStock();

            itemStock.setLockStock(itemStockNow + quantityNeeded);
            stockMapper.updateByPrimaryKey(itemStock);
        }
    }

    private boolean hasStock(List<OrderItem> orderItemList) {

        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();
            ProductSkuExample example = new ProductSkuExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSku itemStock = stockMapper.selectByExample(example).get(0);

            if (itemStock != null && itemStock.getStock() < (itemStock.getLockStock() + quantityNeeded)){
                return false;
            }
        }
        return true;
    }

    private void updateChangeLog(int orderId, int status, String note, String operator) {
        OrderChangeHistory changeLog = new OrderChangeHistory();
        changeLog.setOrderId(orderId);
        changeLog.setOrderStatus(status);
        changeLog.setChangeOperator(operator);
        changeLog.setNote(note);
        changeLog.setCreatedAt(new Date());
        orderChangeHistoryMapper.insert(changeLog);
    }
}
