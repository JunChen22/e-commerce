package com.itsthatjun.ecommerce.service;

import com.itsthatjun.ecommerce.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface OrderService {

    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    @Transactional
    Integer paySuccess(Long OrderId, Integer payType);

    @Transactional
    String cancelOrder(Long orderId);

}
