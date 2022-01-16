package com.itsthatjun.spring.ecommerce.Service.impl;

import com.itsthatjun.spring.ecommerce.Service.OrderService;
import com.itsthatjun.spring.ecommerce.component.CancelOrderSender;
import com.itsthatjun.spring.ecommerce.dto.OrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jun Chen on 5/6/21.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public String generateOrder(OrderParam orderParam) {
        //todo: generate order
        return "order successful";
    }

    @Override
    public String cancelOrder(Long orderId) {
        //todo: cancel order
        return "order id " + orderId + " cancelled";
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        long delayTimes = 30 * 1000;
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
