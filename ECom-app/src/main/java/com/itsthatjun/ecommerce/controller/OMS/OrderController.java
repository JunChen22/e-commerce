package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.config.URLUtils;
import com.itsthatjun.ecommerce.dto.OMS.OrderDetail;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.service.Messaging.OrderMessageService;
import com.itsthatjun.ecommerce.service.OMS.implementation.OrderServiceImpl;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    public static final String PAYPAL_SUCCESS_URL = "order/success";

    private final OrderServiceImpl orderService;

    private final MemberServiceImpl memberService;

    private final OrderMessageService orderMessageService;

    @Autowired
    public OrderController(OrderServiceImpl orderService, MemberServiceImpl memberService, OrderMessageService orderMessageService) {
        this.orderService = orderService;
        this.memberService = memberService;
        this.orderMessageService = orderMessageService;
    }

    @ApiOperation("Get Order Detail by serial number")
    @GetMapping("/detail/{orderSn}")
    public OrderDetail detail(@PathVariable String orderSn) {
        int userId = memberService.getCurrentUser().getId();
        return orderService.getOrderDetail(orderSn, userId);
    }

    @GetMapping("/list")
    @ApiOperation("Get member order based on status code and page size")
    @ApiImplicitParam(name = "status", value = "Order status：-1->All；0->wait for payment；1-> fulfilling；2->send；3->complete；4->closed",
            defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    public List<Orders> list(@RequestParam(required = false, defaultValue = "-1")  int status,
                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        int userId = memberService.getCurrentUser().getId();
        return orderService.list(status, pageNum, pageSize, userId);
    }

    @GetMapping("/payment/getPaymentLink/{orderSn}")
    @ApiOperation("Get payment link to pay later")
    public String getPaymentLink(@PathVariable String orderSn) {
        int userId = memberService.getCurrentUser().getId();
        return orderService.getPaymentLink(orderSn, userId);
    }

    @PostMapping("/generateOrder")
    @ApiOperation(value = "Generate order based on shopping cart, actual transaction")
    public Orders generateOrder(@RequestBody OrderParam orderParam, HttpServletRequest request) {
        String requestUrl = URLUtils.getBaseURl(request);
        String paymentSuccessLink = requestUrl + PAYPAL_SUCCESS_URL;
        String paymentFailLink = requestUrl + "/";

        //int userId = memberService.getCurrentUser().getId();
        int userId = 2;
        orderMessageService.sendOrderGenerateMessage(orderParam, paymentSuccessLink, paymentFailLink, userId);
        return new Orders();
    }

    @GetMapping("/payment/success")
    @ApiOperation("after success paypal payment, actual processing the order , unlock stocks and update info's like coupon and stocks")
    public Orders successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        orderService.paySuccess(paymentId, payerId);
        orderMessageService.sendPaymentSuccessMessage(paymentId, payerId);
        return new Orders();
    }

    @PostMapping("/cancelOrder/{orderSn}")
    @ApiOperation("Cancel order if before sending the order out.")
    public Orders cancelUserOrder(@PathVariable String orderSn) {
        int userId = memberService.getCurrentUser().getId();
        orderMessageService.sendCancelUserOrderMessage(orderSn, userId);
        return new Orders();
    }
}
