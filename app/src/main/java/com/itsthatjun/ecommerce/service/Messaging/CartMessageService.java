package com.itsthatjun.ecommerce.service.Messaging;

import com.itsthatjun.ecommerce.dto.event.oms.OmsCartEvent;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.itsthatjun.ecommerce.dto.event.oms.OmsCartEvent.Type.*;

@Service
public class CartMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendCartAddMessage(CartItem cartItem, int userId) {
        OmsCartEvent event = new OmsCartEvent(ADD_ONE, userId, cartItem);
        rabbitTemplate.convertAndSend("", "cart", event);
    }

    public void sendCartUpdateMessage(CartItem cartItem, int userId) {
        OmsCartEvent event = new OmsCartEvent(UPDATE, userId, cartItem);
        rabbitTemplate.convertAndSend("", "cart", event);
    }

    public void sendCartDeleteMessage(CartItem cartItem, int userId) {
        OmsCartEvent event = new OmsCartEvent(DELETE, userId, cartItem);
        rabbitTemplate.convertAndSend("", "cart", event);
    }

    public void sendCartClearMessage(int userId) {
        OmsCartEvent event = new OmsCartEvent(CLEAR, userId, null);
        rabbitTemplate.convertAndSend("", "cart", event);
    }
}
