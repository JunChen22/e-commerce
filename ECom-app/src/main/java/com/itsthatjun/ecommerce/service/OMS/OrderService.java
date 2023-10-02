package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.Address;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

public interface OrderService {

    @ApiOperation("Get order detail")
    Orders detail(String orderSN);

    @ApiOperation("list all user orders")
    List<Orders> list(int status, int pageNum, int pageSize);

    @ApiOperation("Create the actual transaction and payment")
    Orders generateOrder(OrderParam orderParam, String successUrl, String cancelUrl);

    @ApiOperation("payment successful, redirected from paypal")
    Orders paySuccess(String orderSn, String paymentId, String payerId);

    @ApiOperation("payment unsuccessful, redirected from paypal")
    void payFail(String orderSn);

    @ApiOperation("Member cancel order")
    Orders cancelOrder(String orderSN);

    @ApiOperation("")
    void confirmReceiveOrder(int orderId);
}
