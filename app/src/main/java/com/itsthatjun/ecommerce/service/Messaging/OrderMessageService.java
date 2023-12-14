package com.itsthatjun.ecommerce.service.Messaging;

import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.dto.event.oms.OmsCompletionEvent;
import com.itsthatjun.ecommerce.dto.event.oms.OmsOrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.itsthatjun.ecommerce.dto.event.oms.OmsCompletionEvent.Type.PAYMENT_FAILURE;
import static com.itsthatjun.ecommerce.dto.event.oms.OmsCompletionEvent.Type.PAYMENT_SUCCESS;
import static com.itsthatjun.ecommerce.dto.event.oms.OmsOrderEvent.Type.CANCEL_ORDER;
import static com.itsthatjun.ecommerce.dto.event.oms.OmsOrderEvent.Type.GENERATE_ORDER;

@Service
public class OrderMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrderGenerateMessage(OrderParam orderParam, String successUrl, String cancelUrl, int userId) {
        OmsOrderEvent event = new OmsOrderEvent(GENERATE_ORDER, userId, null, orderParam, successUrl, cancelUrl);
        rabbitTemplate.convertAndSend("", "order", event);
    }

    public void sendCancelUserOrderMessage(String orderSn, int userId) {
        OmsOrderEvent event = new OmsOrderEvent(CANCEL_ORDER, userId, orderSn, null, null, null);
        rabbitTemplate.convertAndSend("", "order", event);
    }

    public void sendDelayedCancelOrderMessage(String orderSn) {
        OmsCompletionEvent event = new OmsCompletionEvent(PAYMENT_FAILURE, orderSn);
        rabbitTemplate.convertAndSend("", "orderDelayedCancel", event);
    }

    public void sendPaymentSuccessMessage(String paymentId, String payerId) {
        OmsCompletionEvent event = new OmsCompletionEvent(PAYMENT_SUCCESS, "", paymentId, payerId);
        rabbitTemplate.convertAndSend("", "orderComplete", event);
    }
}
