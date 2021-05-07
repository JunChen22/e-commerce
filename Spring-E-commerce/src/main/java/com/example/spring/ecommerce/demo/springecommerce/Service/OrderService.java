package com.example.spring.ecommerce.demo.springecommerce.Service;

import com.example.spring.ecommerce.demo.springecommerce.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    @Transactional
    String generateOrder(OrderParam orderParam);

    @Transactional
    String cancelOrder(Long orderId);
}
