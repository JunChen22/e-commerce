package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.dto.OMS.OrderDetail;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderService {

    @ApiOperation(value = "")
    OrderDetail getOrderDetail(String orderSn, int userId);

    @ApiOperation("list all user orders")
    List<Orders> list(int status, int pageNum, int pageSize, int userId);

    @ApiOperation(value = "get payment link to make payment in different time")
    String getPaymentLink(String orderSn, int userId);

    @Transactional
    @ApiOperation("Create the actual transaction and payment")
    Orders generateOrder(OrderParam orderParam, String successUrl, String cancelUrl, int userId);

    @Transactional
    @ApiOperation("payment successful, redirected from paypal")
    Orders paySuccess(String paymentId, String payerId);

    @ApiOperation("payment unsuccessful, redirected from paypal, store token to pay later, 30 minute ttl")
    void delayedCancelOrder(String orderSn);

    @ApiOperation("Member cancel order")
    Orders cancelOrder(String orderSn, int userId);

    // TODO: redis or like Quartz or spring task
    // timed/schedule depend on the deliver time and check UPS
    // then called to change status by redis.
    @ApiOperation("Member received deliver, update order status")
    void confirmReceiveOrder(@PathVariable int orderId);
}
