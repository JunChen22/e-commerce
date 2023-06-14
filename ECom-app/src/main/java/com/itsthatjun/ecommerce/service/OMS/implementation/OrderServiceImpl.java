package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.component.CancelOrderSender;
import com.itsthatjun.ecommerce.dto.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import com.itsthatjun.ecommerce.mbg.model.Member;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
import com.itsthatjun.ecommerce.service.PaypalService;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MemberService memberService;

    // TODO: not yet used, redis
    // private final CancelOrderSender cancelOrderSender;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    public OrderServiceImpl(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public List<CartItem> generateCartItem() {

        /*
        ConfirmOrderResult result = new ConfirmOrderResult();
        //获取购物车信息
        UmsMember currentMember = memberService.getCurrentMember();
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),cartIds);
        result.setCartPromotionItemList(cartPromotionItemList);
        //获取用户收货地址列表
        List<UmsMemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressService.list();
        result.setMemberReceiveAddressList(memberReceiveAddressList);
        //获取用户可用优惠券列表
        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList, 1);
        result.setCouponHistoryDetailList(couponHistoryDetailList);
        //获取用户积分
        result.setMemberIntegration(currentMember.getIntegration());
        //获取积分使用规则
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        result.setIntegrationConsumeSetting(integrationConsumeSetting);
        //计算总金额、活动优惠、应付金额
        ConfirmOrderResult.CalcAmount calcAmount = calcCartAmount(cartPromotionItemList);
        result.setCalcAmount(calcAmount);
        return result;
         */

        // turn cart in
        return null;
    }

    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam) {
        Member currentMember = memberService.getCurrentUser();

        System.out.println("at generating order");
        /*

        List<OmsOrderItem> orderItemList = new ArrayList<>();
        //获取购物车及优惠信息

        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(), orderParam.getCartIds());
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            //生成下单商品信息
            OmsOrderItem orderItem = new OmsOrderItem();
            orderItem.setProductId(cartPromotionItem.getProductId());
            orderItem.setProductName(cartPromotionItem.getProductName());
            orderItem.setProductPic(cartPromotionItem.getProductPic());
            orderItem.setProductAttr(cartPromotionItem.getProductAttr());
            orderItem.setProductBrand(cartPromotionItem.getProductBrand());
            orderItem.setProductSn(cartPromotionItem.getProductSn());
            orderItem.setProductPrice(cartPromotionItem.getPrice());
            orderItem.setProductQuantity(cartPromotionItem.getQuantity());
            orderItem.setProductSkuId(cartPromotionItem.getProductSkuId());
            orderItem.setProductSkuCode(cartPromotionItem.getProductSkuCode());
            orderItem.setProductCategoryId(cartPromotionItem.getProductCategoryId());
            orderItem.setPromotionAmount(cartPromotionItem.getReduceAmount());
            orderItem.setPromotionName(cartPromotionItem.getPromotionMessage());
            orderItem.setGiftIntegration(cartPromotionItem.getIntegration());
            orderItem.setGiftGrowth(cartPromotionItem.getGrowth());
            orderItemList.add(orderItem);
        }

        */


        // check stock if enough

        // check if used coupon

        // calculate prices

        // lock stock

        // calculate order price, shipping, promotion, coupon


        // TODO: payment by paypal
        // paypalService.createPayment();
        // paypalService.executePayment();


        // update/finish putting order data like
        // order_status, pay type, create time, member, pay amount


        // deliver/receiver address


        // 0->未确认；1->已确认
        // order.setConfirmStatus(0);
        // order.setDeleteStatus(0);


        // generate order number


        // TODO: return estimated shipping/recieve date from like UPS, currently just set it to 5 days



        // put in order and order_item into database


        // update coupon used counts and history if used


        // delete member shopping cart

        return null;
    }

    @Override
    public Integer paySuccess(Long OrderId, Integer payType) {



        return null;
    }

    @Override
    public String cancelOrder(Long orderId) {
        //todo: cancel order
        return "order id " + orderId + " cancelled";
    }

    @Override
    public List<Orders> list(int status, int pageNum, int pageSize) {
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
}
