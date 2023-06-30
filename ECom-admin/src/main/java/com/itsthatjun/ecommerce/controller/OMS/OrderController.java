package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.mbg.model.Orders;
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

    @GetMapping("/payment")
    @ApiOperation(value = "List all orders that need to be paid")
    public List<Orders> listAllOrdersWaitForPayment(){
        return orderService.getAllWaitingForPayment();
    }

    @GetMapping("/fulfill")
    @ApiOperation(value = "List all orders that need to be fulfill/open")
    public List<Orders> listAllFulfullingOrders(){
        return orderService.getAllFulfulling();
    }

    @GetMapping("/send")
    @ApiOperation(value = "List all orders that are send")
    public List<Orders> listAllSendOrders(){
        return orderService.getAllInSend();
    }

    @GetMapping("/complete")
    @ApiOperation(value = "List all orders that are delivered")
    public List<Orders> listAl(){
        return orderService.getAllCompleteOrder();
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "get all orders made by user")
    public List<Orders> getUserOrders(@PathVariable int id){
        return orderService.getUserOrders(id);
    }

    @GetMapping("/{serialNumber}")
    @ApiOperation(value = "look up a order by serial number")
    public Orders getOrder(@PathVariable String serialNumber){
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
    public void deleteOrder(@PathVariable String serialNumber){
        orderService.cancelOrder(serialNumber);
    }
}
