package com.example.spring.ecommerce.demo.springecommerce.controller.order;

import com.example.spring.ecommerce.demo.springecommerce.Service.OrderService;
import com.example.spring.ecommerce.demo.springecommerce.dto.OrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jun Chen on 5/6/21.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/generateOrder")
    public String generateOrder(@RequestBody OrderParam orderParam){
        return orderService.generateOrder(orderParam);
    }
}
