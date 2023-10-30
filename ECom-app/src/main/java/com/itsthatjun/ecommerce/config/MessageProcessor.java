package com.itsthatjun.ecommerce.config;

import com.itsthatjun.ecommerce.dto.UMS.MemberDetail;
import com.itsthatjun.ecommerce.dto.ReturnParam;
import com.itsthatjun.ecommerce.dto.event.oms.OmsCartEvent;
import com.itsthatjun.ecommerce.dto.event.oms.OmsCompletionEvent;
import com.itsthatjun.ecommerce.dto.event.oms.OmsOrderEvent;
import com.itsthatjun.ecommerce.dto.event.oms.OmsReturnEvent;
import com.itsthatjun.ecommerce.dto.event.pms.PmsReviewEvent;
import com.itsthatjun.ecommerce.dto.event.ums.UmsUserEvent;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.implementation.CartItemServiceImpl;
import com.itsthatjun.ecommerce.service.OMS.implementation.OrderServiceImpl;
import com.itsthatjun.ecommerce.service.OMS.implementation.ReturnOrderServiceImpl;
import com.itsthatjun.ecommerce.service.PMS.implementation.ReviewServiceImpl;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MessageProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(MessageProcessor.class);

    private final OrderServiceImpl orderService;

    private final ReturnOrderServiceImpl returnOrderService;

    private final CartItemServiceImpl cartItemService;

    private final ReviewServiceImpl reviewService;

    private final MemberServiceImpl memberService;

    @Autowired
    public MessageProcessor(OrderServiceImpl orderService, ReturnOrderServiceImpl returnOrderService, CartItemServiceImpl cartItemService,
                            ReviewServiceImpl reviewService, MemberServiceImpl memberService) {
        this.orderService = orderService;
        this.returnOrderService = returnOrderService;
        this.cartItemService = cartItemService;
        this.reviewService = reviewService;
        this.memberService = memberService;
    }

    @RabbitListener(queues = "order")
    public void orderMessageProcessor(OmsOrderEvent event) {
        LOG.info("Process message created at {}...", event.getEventCreatedAt());

        switch (event.getEventType()) {
            case GENERATE_ORDER:
                orderService.generateOrder(event.getOrderParam(), event.getSuccessUrl(), event.getCancelUrl(), event.getUserId());
                break;

            case CANCEL_ORDER:
                String orderSn = event.getOrderSn();
                //orderService.cancelOrder(orderSn, event.getUserId());
                break;

            // case UPDATE_ORDER:  TODO: update order minutes after order placed, like change quantity or cancel partial order

            default:
                String errorMessage = "Incorrect event type:" + event.getEventType() + ", expected GENERATE_ORDER, CANCEL_ORDER, " +
                        "and UPDATE_ORDER event";
                LOG.warn(errorMessage);
                throw new RuntimeException(errorMessage);
        }
    }

    @RabbitListener(queues = "orderComplete")
    public void orderCompleteMessageProcessor(OmsCompletionEvent event) {
        LOG.info("Process message created at {}...", event.getEventCreatedAt());
        switch (event.getEventType()) {
            case PAYMENT_SUCCESS:
                orderService.paySuccess(event.getPaymentId(), event.getPayerId());
                break;

            case PAYMENT_FAILURE:
                orderService.delayedCancelOrder(event.getOrderSn());
                break;

            default:
                String errorMessage = "Incorrect event type:" + event.getEventType() + ", expected PAYMENT_SUCCESS and PAYMENT_FAILURE event";
                LOG.warn(errorMessage);
                throw new RuntimeException(errorMessage);
        }
    }

    @RabbitListener(queues = "return")
    public void returnMessageProcessor(OmsReturnEvent event) {
        LOG.info("Process message created at {}...", event.getEventCreatedAt());

        int userId = event.getUserId();

        ReturnParam returnParam = event.getReturnParam();
        ReturnRequest returnRequest = returnParam.getReturnRequest();
        List<ReturnReasonPictures> pictures = returnParam.getPicturesList();
        String orderSn = returnParam.getReturnRequest().getOrderSn();

        switch (event.getEventType()) {
            case APPLY:
                Map<String, Integer> skuQuantity = returnParam.getSkuQuantity();
                returnOrderService.applyForReturn(returnRequest, pictures, skuQuantity,userId);
                break;

            case UPDATE:
                returnOrderService.updateReturnInfo(returnRequest, pictures, orderSn, userId);
                break;

            case CANCEL:
                returnOrderService.cancelReturn(orderSn, userId);
                break;

            case REJECT:
                returnOrderService.delayedRejectReturn(orderSn, userId);
                break;

            default:
                String errorMessage = "Incorrect event type:" + event.getEventType() + ", expected APPLY, UPDATE, CANCEL and REJECT event";
                LOG.warn(errorMessage);
                throw new RuntimeException(errorMessage);
        }
    }

    @RabbitListener(queues = "cart")
    public void cartMessageProcessor(OmsCartEvent event) {
        LOG.info("Process message created at {}...", event.getEventCreatedAt());

        CartItem cartItem = event.getCartItem();
        int userId = event.getUserId();
        int cartItemId;

        switch (event.getEventType()) {
            case ADD_ONE:
                cartItemService.addItem(cartItem, userId);
                break;

            case UPDATE:
                int quantity = cartItem.getQuantity();
                cartItemId = cartItem.getCartId();
                cartItemService.updateQuantity(cartItemId, quantity, userId);
                break;

            case DELETE:
                cartItemId = cartItem.getCartId();
                cartItemService.deleteCartItem(cartItemId, userId);
                break;

            case CLEAR:
                cartItemService.clearCartItem(userId);
                break;

            default:
                String errorMessage = "Incorrect event type:" + event.getEventType() + ", expected ADD_ONE, ADD_ALL, " +
                        "UPDATE, DELETE, and CLEAR event";
                LOG.warn(errorMessage);
                throw new RuntimeException(errorMessage);
        }
    }

    @RabbitListener(queues = "review")
    public void reviewMessageProcessor(PmsReviewEvent event) {
        LOG.info("Process message created at {}...", event.getEventCreatedAt());
        Review review = event.getReview();
        int userId = event.getUserId();
        switch (event.getEventType()) {
            case CREATE_REVIEW:
                reviewService.createReview(review, event.getPicturesList(), userId);
                break;

            case UPDATE_REVIEW:
                reviewService.updateReview(review, event.getPicturesList(), userId);
                break;

            case DELETE_REVIEW:
                int reviewId = review.getId();
                reviewService.deleteReview(reviewId, userId);
                break;

            default:
                String errorMessage = "Incorrect event type:" + event.getEventType() + ", expected CREATE_REVIEW, UPDATE_REVIEW, DELETE_REVIEW event";
                LOG.warn(errorMessage);
                throw new RuntimeException(errorMessage);
        }
    }

    @RabbitListener(queues = "user")
    public void userMessageProcessor(UmsUserEvent event) {
        LOG.info("Process message created at {}...", event.getEventCreatedAt());

        MemberDetail memberDetail = event.getMemberDetail();
        switch (event.getEventType()) {
            case NEW_ACCOUNT:
                memberService.register(memberDetail);
                break;

            case UPDATE_PASSWORD:
                int userId = memberDetail.getMember().getId();
                String newPassword = memberDetail.getMember().getPassword();
                memberService.updatePassword(userId, newPassword);
                break;

            case UPDATE_ACCOUNT_INFO:
                memberService.updateInfo(memberDetail);
                break;

            case UPDATE_ADDRESS:
                Address newAddress = memberDetail.getAddress();
                memberService.updateAddress(memberDetail.getMember().getId(), newAddress);
                break;

            case DELETE_ACCOUNT:
                memberService.deleteAccount(memberDetail.getMember().getId());
                break;

            default:
                String errorMessage = "Incorrect event type:" + event.getEventType() + ", expected NEW_ACCOUNT, " +
                        "UPDATE_PASSWORD, UPDATE_ACCOUNT_INFO, UPDATE_ACCOUNT_INFO, UPDATE_ADDRESS and DELETE_ACCOUNT event";
                LOG.warn(errorMessage);
                throw new RuntimeException(errorMessage);
        }
    }
}
