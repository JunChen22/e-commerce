package com.itsthatjun.ecommerce.service.impl;

import com.itsthatjun.ecommerce.component.CancelOrderSender;
import com.itsthatjun.ecommerce.dto.OrderParam;
import com.itsthatjun.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jun Chen on 5/6/21.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CancelOrderSender cancelOrderSender;


    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam) {
        //todo: generate order
        Map<String, Object> result = new HashMap<>();
        return result;
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

    private void sendDelayMessageCancelOrder(Long orderId) {
        long delayTimes = 30 * 1000;
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
