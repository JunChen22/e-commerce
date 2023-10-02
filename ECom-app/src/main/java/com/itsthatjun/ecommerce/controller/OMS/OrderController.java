package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.config.URLUtils;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.Address;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.service.OMS.implementation.OrderServiceImpl;
import com.itsthatjun.ecommerce.service.PaypalService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String PAYPAL_SUCCESS_URL = "order/success";
    public static final String PAYPAL_CANCEL_URL = "order/cancel";

    private Logger LOG = LoggerFactory.getLogger(getClass());

    private final OrderServiceImpl orderService;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @ApiOperation("Get member order based on status code and page size")
    @ApiImplicitParam(name = "status", value = "Order status：-1->All；0->wait for payment；1-> fulfilling；2->send；3->complete；4->closed",
            defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    @GetMapping("/list")
    public List<Orders> list(@RequestParam(required = false, defaultValue = "-1")  int status,
                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        return orderService.list(status, pageNum, pageSize);
    }

    @ApiOperation("Get Order Detail by serial number")
    @GetMapping("/detail/{orderSn}")
    public Orders detail(@PathVariable String orderSn) {
        return orderService.detail(orderSn);
    }

    @PostMapping("/generateOrder")
    @ApiOperation(value = "Generate order based on shopping cart, actual transaction")
    public Orders generateOrder(@RequestBody OrderParam orderParam , HttpServletRequest request, HttpSession session){
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;

        Orders newOrder = orderService.generateOrder(orderParam, successUrl, cancelUrl);
        String orderSn = newOrder.getOrderSn();
        session.setAttribute("newOrderSn", orderSn);

        return newOrder;
    }

    @GetMapping("/success")
    @ApiOperation("after success paypal payment, actual processing the order , unlock stocks and update info's like coupon and stocks")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, HttpSession session){
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);

            if(payment.getState().equals("approved")){
                System.out.println("successful payment");
                String orderSn = session.getAttribute("newOrderSn").toString();
                session.removeAttribute("newOrderSn");
                orderService.paySuccess(orderSn, paymentId, payerId);
                return "success";
            }

        } catch (PayPalRESTException e) {
            LOG.error(e.getMessage());
        }
        System.out.println("error payment");
        return "redirect:/";
    }

    @ApiOperation("Payment failure feedback")
    @GetMapping("/cancel")
    public String payFail(HttpSession session) {
        String orderSn = session.getAttribute("newOrderSn").toString();
        session.removeAttribute("newOrderSn");
        orderService.payFail(orderSn);
        return null;
    }

    @ApiOperation("Cancel order")
    @PostMapping("/cancelOrder/{orderSn}")
    public Orders cancelUserOrder(@PathVariable String orderSn) {
        return orderService.cancelOrder(orderSn);
    }
}
