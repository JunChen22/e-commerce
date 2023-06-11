package com.itsthatjun.ecommerce.component;

import com.itsthatjun.ecommerce.service.OMS.implementation.OrderServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "order.cancel")
public class CancelOrderReceiver {
    @Autowired
    private OrderServiceImpl orderService;

    @RabbitHandler
    public void handle(Long orderId){
        orderService.cancelOrder(orderId);
    }
}