package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.OrderReturnApply;

import java.util.List;

public interface ReturnOrderService {

    // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3

    List<OrderReturnApply> getAllOpening();

    List<OrderReturnApply> getAllReturning();

    List<OrderReturnApply> getAllCompleted();

    List<OrderReturnApply> getAllRejected();

    // get specific return
    OrderReturnApply getOrderReturnDetail(String orderSn);

    // approve return request
    OrderReturnApply approveReturnRequest(OrderReturnApply returnRequest);

    // reject return request
    OrderReturnApply rejectReturnRequest(OrderReturnApply returnRequest);

    // update
    OrderReturnApply updateReturnOrderStatus(OrderReturnApply newReturnRequest);

}
