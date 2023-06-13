package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.dto.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @ApiOperation("Generate confirm order, list of product with prices calculated")
    @PostMapping("/generateConfirmOrder")
    public String generateConfirmOrder(@RequestBody List<Integer> cartIds) {
        return null;
    }

    @PostMapping("/generateOrder")
    @ApiOperation(value = "Generate order based on shopping cart, actual transaction")
    public Map<String, Object> generateOrder(@RequestBody OrderParam orderParam){
        System.out.println("hello, at generate order");
        return orderService.generateOrder(orderParam);
    }

    @ApiOperation("Payment success feedback")
    @PostMapping("/paySuccess")
    public String paySuccess(@RequestParam int orderId,@RequestParam int payType) {
        return null;
    }

    @ApiOperation("Get member order based on status code and page size")
    @ApiImplicitParam(name = "status", value = "Order status：-1->All；0->wait for payment；1-> fulfilling；2->send；3->complete；4->closed",
            defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    @GetMapping("/list")
    public List<Orders> list(@RequestParam Integer status,
                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        return orderService.list(status,pageNum,pageSize);
    }

    @ApiOperation("Get Order Detail")
    @GetMapping("/detail/{orderId}")
    public Orders detail(@PathVariable int orderId) {
        return null;
    }

    @ApiOperation("Cancel order")
    @PostMapping("/cancelOrder")
    public Orders cancelUserOrder(Long orderId) {
        return null;
    }


    // TODO: redis
    // timed/schedule depend on the deliver time and check UPS
    // then called to change status by redis.
    @ApiOperation("Member received deliver, update order status")
    @PostMapping(value = "/confirmReceiveOrder/{orderId}")
    public String confirmReceiveOrder(@PathVariable int orderId) {
        return null;
    }
}
