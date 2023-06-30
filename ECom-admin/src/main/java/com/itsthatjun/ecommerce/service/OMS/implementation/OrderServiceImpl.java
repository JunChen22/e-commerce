package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.exceptions.OMS.OrderException;
import com.itsthatjun.ecommerce.mbg.mapper.OrdersMapper;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.mbg.model.OrdersExample;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrdersMapper ordersMapper;

    @Autowired
    public OrderServiceImpl(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    // TODO: change these based of status code and add 4 and 5 in
    // waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5
    @Override
    public List<Orders> getAllWaitingForPayment() {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andStatusEqualTo(0);
        List<Orders> orderWaitingForPayment = ordersMapper.selectByExample(example);
        return orderWaitingForPayment;
    }

    @Override
    public List<Orders> getAllFulfulling() {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andStatusEqualTo(1);
        List<Orders> orderWaitingToBeFulfill = ordersMapper.selectByExample(example);
        return orderWaitingToBeFulfill;
    }

    @Override
    public List<Orders> getAllInSend() {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andStatusEqualTo(2);
        List<Orders> orderInTransit = ordersMapper.selectByExample(example);
        return orderInTransit;
    }

    @Override
    public List<Orders> getAllCompleteOrder() {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andStatusEqualTo(3);
        List<Orders> orderCompletedOrder = ordersMapper.selectByExample(example);
        return orderCompletedOrder;
    }

    @Override
    public Orders getOrderByOrderNumber(String orderSerialNumber) {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andOrderSnEqualTo(orderSerialNumber);
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        if (ordersList.size() == 0)
            throw new OrderException("Order number does not exist: " + orderSerialNumber);
        return ordersList.get(0);
    }

    @Override
    public List<Orders> getUserOrders(int memberId) {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        return ordersList;
    }

    @Override
    public Orders createOrder(Orders newOrder) {
        // TODO: replace this simple one to more accurate one
        //  need to generate order serial number
        int status = ordersMapper.insert(newOrder);
        return newOrder;
    }

    @Override
    public Orders updateOrder(Orders updateOrder) {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andOrderSnEqualTo(updateOrder.getOrderSn());

        int status = ordersMapper.updateByExample(updateOrder, example);

        return updateOrder;
    }

    @Override
    public void cancelOrder(String orderSerialNumber) {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andOrderSnEqualTo(orderSerialNumber);
        // TODO: cancel order/delete
        ordersMapper.deleteByExample(example);
    }
}
