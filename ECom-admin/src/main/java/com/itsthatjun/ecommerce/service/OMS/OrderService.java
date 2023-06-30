package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.Orders;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface OrderService {

    @ApiModelProperty(value = "")//  waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5
    List<Orders> getAllWaitingForPayment();

    @ApiModelProperty(value = "")
    List<Orders> getAllFulfulling();

    @ApiModelProperty(value = "")
    List<Orders> getAllInSend();

    @ApiModelProperty(value = "")
    List<Orders> getAllCompleteOrder();

    @ApiModelProperty(value = "get by order number")
    Orders getOrderByOrderNumber(String orderSerialNumber);

    @ApiModelProperty(value = "get all orders from user")
    List<Orders> getUserOrders(int memberId);

    @ApiModelProperty(value = "create order")
    Orders createOrder(Orders newOrder);

    @ApiModelProperty(value = "update an order")
    Orders updateOrder(Orders updateOrder);

    @ApiModelProperty(value = "cancel an order")
    void cancelOrder(String orderSerialNumber);
}
