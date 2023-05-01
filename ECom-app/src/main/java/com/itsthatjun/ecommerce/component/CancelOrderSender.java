package com.itsthatjun.ecommerce.component;

import com.itsthatjun.ecommerce.dto.QueueEnum;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Jun Chen on 5/6/21.
 */
@Component
public class CancelOrderSender {

    private AmqpTemplate amqpTemplate;

    public void sendMessage(Long orderId,final long delayTimes){

        amqpTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_CANCEL.getExchange(), QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(), orderId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("x-delay",delayTimes);
                return message;
            }
        });
    }
}
