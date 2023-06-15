package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.config.PaypalPaymentIntent;
import com.itsthatjun.ecommerce.config.PaypalPaymentMethod;
import com.itsthatjun.ecommerce.config.URLUtils;
import com.itsthatjun.ecommerce.dto.OMS.ConfirmOrderResult;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.exceptions.OMS.OrderException;
import com.itsthatjun.ecommerce.mbg.mapper.CouponMapper;
import com.itsthatjun.ecommerce.mbg.mapper.OrderItemMapper;
import com.itsthatjun.ecommerce.mbg.mapper.OrdersMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ReceiveAddressMapper;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
import com.itsthatjun.ecommerce.service.PaypalService;
import com.itsthatjun.ecommerce.service.SMS.implementation.CouponServiceImpl;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.itsthatjun.ecommerce.controller.PaymentController.PAYPAL_CANCEL_URL;
import static com.itsthatjun.ecommerce.controller.PaymentController.PAYPAL_SUCCESS_URL;

@Service
public class OrderServiceImpl implements OrderService {

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
    public Map<String, Object> generateOrder(OrderParam orderParam) {
        Member currentMember = memberService.getCurrentUser();

        List<OrderItem> orderItemList = new ArrayList<>();
        List<Integer> productIds = new ArrayList<>();
        // calculate prices
        double price = 0;

        for (CartItem item : orderParam.getCartItemList()) {
            // generate order item information
            productIds.add(item.getProductId());
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(item.getProductId());
            orderItem.setProductName(item.getProductName());
            orderItem.setProductPrice(item.getPrice());

            /*
                TODO: other infos

                ReceiveAddress
             */
            price += item.getPrice().doubleValue();
            orderItemList.add(orderItem);
        }

        /*
        // check stock if enough
        if (!hasStock()) {
            throw new OrderException("Not enough stock, Unable to order");
        }

        // lock stock
        lockStock();

        // calculate order price, shipping, promotion, coupon

        // check shipping cost, $50 or more get free shipping or $15
        ReceiveAddressExample addressExample = new ReceiveAddressExample();
        addressExample.createCriteria().andMemberIdEqualTo(currentMember.getId());
        ReceiveAddress address = addressMapper.selectByExample(addressExample).get(0);

        // TODO: calculate shipping cost from UPS API, currently just fixed rate
        double shippingCost = 15;  // default shipping cost before UPS check
        if (price > 50) {
            shippingCost = 0;
        }

        double couponDiscount = calculateCouponDiscount(productIds, orderParam.getCoupon());

        price = price - couponDiscount + shippingCost;

        // TODO: payment by paypal
        // paypalService.createPayment();
        // paypalService.executePayment();


        // update/finish putting order data like
        // order_status, pay type, create time, member, pay amount



        // 0->未确认；1->已确认
        // order.setConfirmStatus(0);
        // order.setDeleteStatus(0);

        // generate order number
        Orders newOrder = new Orders();
        String orderSNn = generateOrderSn();
        newOrder.setOrderSn(orderSNn);
        // TODO: return estimated shipping/recieve date from like UPS, currently just set it to 5 days


        // put in order and order_item into database
        ordersMapper.insert(newOrder);

        for (OrderItem item : orderItemList) {
            item.setOrderId(newOrder.getId());
            item.setOrderSn(orderSNn);

            orderItemMapper.insert(item);
        }

        */

        /*


        // update coupon used counts and history if used
        couponService.updateUsedCoupon(orderParam.getCoupon(), newOrder.getId(), currentMember.getId());

        // delete member shopping cart
        cartItemService.clearCartItem();

        Map<String, Object> result = new HashMap<>();
        result.put("Order :", newOrder);
        result.put("Order Item List :", orderItemList);

        return result;
         */

        return null;
    }

    @Override
    public Integer paySuccess(Long OrderId, Integer payType) {
        return null;
    }

    @Override
    public Integer payFail(Long OrderId, Integer payType) {
        return null;
    }

    @Override
    public String cancelOrder(Long orderId) {
        //todo: cancel order
        return "order id " + orderId + " cancelled";
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
    public Orders detail(int orderId) {
        return null;
    }

    // TODO: use a better way to generate order serial number
    private String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // use date and today order number?
        //  2023 + 0613  +
        return null;
    }

    private void lockStock() {

    }

    private boolean hasStock() {
        return false;
    }
}
