package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.config.URLUtils;
import com.itsthatjun.ecommerce.dto.OMS.ConfirmOrderResult;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.mbg.model.ReceiveAddress;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
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
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String PAYPAL_SUCCESS_URL = "order/success";
    public static final String PAYPAL_CANCEL_URL = "order/cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    private final OrderServiceImpl orderService;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @ApiOperation("Generate confirm order, list of product with prices calculated")
    @PostMapping("/generateConfirmOrder")
    public ConfirmOrderResult generateConfirmOrder(@RequestBody List<CartItem> cartItems,
                                                   @RequestParam(required = false, defaultValue = "") String coupon) {
        return orderService.generateCartItem(cartItems, coupon);
    }

    @PostMapping("/generateOrder")
    @ApiOperation(value = "Generate order based on shopping cart, actual transaction")
    public Map<String, Object> generateOrder(@RequestBody OrderParam orderParam , HttpServletRequest request, HttpSession session){
        session.setAttribute("shippingAddress", orderParam.getAddress());
        session.setAttribute("couponCode", orderParam.getCoupon());

        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
        return orderService.generateOrder(orderParam, successUrl, cancelUrl);
    }

    @GetMapping("/success")
    @ApiOperation("after success paypal payment, actual processing the order , unlock stocks and update info's like coupon and stocks")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, HttpSession session){
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);

            if(payment.getState().equals("approved")){
                System.out.println("successful payment");
                String couponCode = session.getAttribute("couponCode").toString();
                ReceiveAddress address = (ReceiveAddress) session.getAttribute("shippingAddress");
                orderService.paySuccess(couponCode, address);
                return "success";
            }

        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        System.out.println("error payment");
        return "redirect:/";
    }

    @ApiOperation("Payment failure feedback")
    @GetMapping("/cancel")
    public String payFail() {
        orderService.payFail();
        return null;
    }

    @ApiOperation("Get member order based on status code and page size")
    @ApiImplicitParam(name = "status", value = "Order status：-1->All；0->wait for payment；1-> fulfilling；2->send；3->complete；4->closed",
            defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    @GetMapping("/list")
    public List<Orders> list(@RequestParam(required = false, defaultValue = "-1")  int status,
                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        return orderService.list(status,pageNum,pageSize);
    }

    @ApiOperation("Get Order Detail by serial number")
    @GetMapping("/detail/{orderSn}")
    public Orders detail(@PathVariable String orderSn) {
        return orderService.detail(orderSn);
    }

    @ApiOperation("Cancel order")
    @PostMapping("/cancelOrder/{orderSn}")
    public String cancelUserOrder(@PathVariable String orderSn) {
        return orderService.cancelOrder(orderSn);
    }

    // TODO: redis or like Quartz
    // timed/schedule depend on the deliver time and check UPS
    // then called to change status by redis.
    @ApiOperation("Member received deliver, update order status")
    @PostMapping(value = "/confirmReceiveOrder/{orderId}")
    public String confirmReceiveOrder(@PathVariable int orderId) {
        return null;
    }
}
