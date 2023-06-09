package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.service.OMS.implementation.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(tags = "Order related", description = "retrieve information about an order(s) and change order")
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/fulfill")
    @ApiOperation(value = "List all orders that need to be fulfill/open")
    public List<Orders> listALlFulfullingOrders(){
        return orderService.getAllFulfulling();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get all orders made by user")
    public List<Orders> getUserOrders(@PathVariable int id){
        return orderService.getUserOrders(id);
    }

    @GetMapping("/{serialNumber}")
    @ApiOperation(value = "look up a order by serial number")
    public Orders getOrder(@PathVariable int serialNumber){
        Orders order = orderService.getOrderByOrderNumber(serialNumber);
        return order;
    }

    @PostMapping("/create")
    @ApiOperation(value = "create order")
    public Orders createOrder(@RequestBody Orders newOrder){
        orderService.createOrder(newOrder);
        return newOrder;
    }

    @PostMapping("/update")
    @ApiOperation(value = "update a order")
    public Orders updateOrder(Orders updateOrder){
        orderService.updateOrder(updateOrder);
        return updateOrder;
    }

    @DeleteMapping("/delete/{serialNumber}")
    @ApiOperation(value = "delete a order by serial number")
    public void deleteOrder(@PathVariable int serialNumber){
        orderService.deleteOrder(serialNumber);
    }
}
