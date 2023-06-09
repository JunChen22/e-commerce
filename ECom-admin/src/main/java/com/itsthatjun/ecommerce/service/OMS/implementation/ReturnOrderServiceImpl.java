package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.OrderReturnApplyMapper;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnApply;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnApplyExample;
import com.itsthatjun.ecommerce.service.OMS.ReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {


    private final OrderReturnApplyMapper returnApplyMapper;

    @Autowired
    public ReturnOrderServiceImpl(OrderReturnApplyMapper returnApplyMapper) {
        this.returnApplyMapper = returnApplyMapper;
    }

    // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3
    @Override
    public List<OrderReturnApply> getAllOpening() {
        OrderReturnApplyExample example = new OrderReturnApplyExample();
        example.createCriteria().andStatusEqualTo(0);

        List<OrderReturnApply> orderReturnRequests = returnApplyMapper.selectByExample(example);

        return orderReturnRequests;
    }

    @Override
    public List<OrderReturnApply> getAllReturning() {
        OrderReturnApplyExample example = new OrderReturnApplyExample();
        example.createCriteria().andStatusEqualTo(1);
        List<OrderReturnApply> returningRequests = returnApplyMapper.selectByExample(example);

        return returningRequests;
    }

    @Override
    public List<OrderReturnApply> getAllCompleted() {
        OrderReturnApplyExample example = new OrderReturnApplyExample();
        example.createCriteria().andStatusEqualTo(2);
        List<OrderReturnApply> completedReturns = returnApplyMapper.selectByExample(example);

        return completedReturns;
    }

    @Override
    public List<OrderReturnApply> getAllRejected() {
        OrderReturnApplyExample example = new OrderReturnApplyExample();
        example.createCriteria().andStatusEqualTo(3);
        List<OrderReturnApply> rejectedRequests = returnApplyMapper.selectByExample(example);

        return rejectedRequests;
    }

    @Override
    public OrderReturnApply getOrderReturnDetail(int orderSn) {
        OrderReturnApplyExample example = new OrderReturnApplyExample();
        example.createCriteria().andOrderSnEqualTo(orderSn);

        List<OrderReturnApply> returnRequest = returnApplyMapper.selectByExample(example);

        return returnRequest.get(0);
    }

    @Override
    public OrderReturnApply approveReturnRequest(OrderReturnApply returnRequest) {
        returnApplyMapper.updateByPrimaryKey(returnRequest);
        return returnRequest;
    }

    @Override
    public OrderReturnApply rejectReturnRequest(OrderReturnApply returnRequest) {
        returnApplyMapper.updateByPrimaryKey(returnRequest);
        return returnRequest;
    }

    @Override
    public OrderReturnApply updateReturnOrderStatus(OrderReturnApply newReturnRequest) {
        returnApplyMapper.updateByPrimaryKey(newReturnRequest);
        return newReturnRequest;
    }
}
