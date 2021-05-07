package com.example.spring.ecommerce.demo.springecommerce.component;

import com.example.spring.ecommerce.demo.springecommerce.Service.impl.OrderServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jun Chen on 5/6/21.
 */
@RabbitListener(queues = "order.cancel")
public class CancelOrderReceiver {
    @Autowired
    private OrderServiceImpl orderService;

    @RabbitHandler
    public void handle(Long orderId){
        orderService.cancelOrder(orderId);
    }
}