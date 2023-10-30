package com.itsthatjun.ecommerce.config;

import com.itsthatjun.ecommerce.dto.ReturnParam;
import com.itsthatjun.ecommerce.dto.event.oms.OmsCompletionEvent;
import com.itsthatjun.ecommerce.dto.event.oms.OmsOrderEvent;
import com.itsthatjun.ecommerce.dto.event.oms.OmsReturnEvent;
import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import com.itsthatjun.ecommerce.service.OMS.implementation.OrderServiceImpl;
import com.itsthatjun.ecommerce.service.OMS.implementation.ReturnOrderServiceImpl;
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

    @Autowired
    public MessageProcessor(OrderServiceImpl orderService, ReturnOrderServiceImpl returnOrderService) {
        this.orderService = orderService;
        this.returnOrderService = returnOrderService;
    }

    @RabbitListener(queues = "order")
    public void orderMessageProcessor(OmsOrderEvent event) {
        LOG.info("Process message created at {}...", event.getEventCreatedAt());

        switch (event.getEventType()) {
            case GENERATE_ORDER:
                System.out.println("at generating order");
                System.out.println(event);
                orderService.generateOrder(event.getOrderParam(), event.getSuccessUrl(), event.getCancelUrl(), event.getUserId());
                break;

            case CANCEL_ORDER:
                String orderSn = event.getOrderSn();
                System.out.println("at cancel order");
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
}
