package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.dto.OMS.ConfirmOrderResult;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.mbg.model.ReceiveAddress;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderService {

    @ApiModelProperty("Generate confirmed order with prices all calculate include shipping and taxes")
    ConfirmOrderResult generateCartItem(List<CartItem> cartItems, String coupon);

    @Transactional
    @ApiModelProperty("Create the actual transaction and payment")
    Map<String, Object> generateOrder(OrderParam orderParam, String successUrl, String cancelUrl);

    @Transactional
    @ApiModelProperty("payment successful, redirected from paypal")
    Orders paySuccess(String couponCode, ReceiveAddress address);

    @ApiModelProperty("payment unsuccessful, redirected from paypal")
    void payFail();

    @Transactional
    @ApiModelProperty("Member cancel order")
    String cancelOrder(String orderSN);

    @ApiModelProperty("list all user orders")
    List<Orders> list(int status, int pageNum, int pageSize);

    @ApiModelProperty("Get order detail")
    Orders detail(String orderSN);
}
