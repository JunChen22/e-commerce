package com.itsthatjun.ecommerce.service.Messaging;

import com.itsthatjun.ecommerce.dto.ReturnParam;
import com.itsthatjun.ecommerce.dto.event.oms.OmsReturnEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.itsthatjun.ecommerce.dto.event.oms.OmsReturnEvent.Type.*;

@Service
public class ReturnMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendReturnRequestApplyMessage(ReturnParam returnParam, int userId) {
        OmsReturnEvent event = new OmsReturnEvent(APPLY, userId, returnParam);
        rabbitTemplate.convertAndSend("", "return", event);
    }

    public void sendReturnRequestUpdateMessage(ReturnParam returnParam, int userId) {
        OmsReturnEvent event = new OmsReturnEvent(UPDATE, userId, returnParam);
        rabbitTemplate.convertAndSend("", "return", event);
    }

    public void sendReturnRequestCancelMessage(ReturnParam returnParam, int userId) {
        OmsReturnEvent event = new OmsReturnEvent(CANCEL, userId, returnParam);
        rabbitTemplate.convertAndSend("", "return", event);
    }

    public void sendDelayedReturnRequestReject(ReturnParam returnParam, int userId) {
        OmsReturnEvent event = new OmsReturnEvent(REJECT, userId, returnParam);
        rabbitTemplate.convertAndSend("", "returnDelayedRejection", event);
    }
}
