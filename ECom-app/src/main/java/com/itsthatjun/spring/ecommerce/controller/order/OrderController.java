package com.itsthatjun.spring.ecommerce.controller.order;

import com.itsthatjun.spring.ecommerce.Service.OrderService;
import com.itsthatjun.spring.ecommerce.dto.OrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Jun Chen on 5/6/21.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/generateOrder")
    public Map<String, Object> generateOrder(@RequestBody OrderParam orderParam){
        return orderService.generateOrder(orderParam);
    }
}
