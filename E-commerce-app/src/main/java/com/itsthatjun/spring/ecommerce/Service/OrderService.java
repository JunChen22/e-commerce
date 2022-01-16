package com.itsthatjun.spring.ecommerce.Service;

import com.itsthatjun.spring.ecommerce.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    @Transactional
    String generateOrder(OrderParam orderParam);

    @Transactional
    String cancelOrder(Long orderId);
}
