package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.Orders;

import java.util.List;

public interface OrderService {

    //  waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5
    List<Orders> getAllWaitingForPayment();

    List<Orders> getAllFulfulling();

    List<Orders> getAllInSend();

    List<Orders> getAllCompleteOrder();

    // get by order number
    Orders getOrderByOrderNumber(String orderSerialNumber);

    // get all orders from user
    List<Orders> getUserOrders(int memberId);

    // create order
    Orders createOrder(Orders newOrder);

    // update an order
    Orders updateOrder(Orders updateOrder);

    // delete an order
    void deleteOrder(String orderSerialNumber);
}
