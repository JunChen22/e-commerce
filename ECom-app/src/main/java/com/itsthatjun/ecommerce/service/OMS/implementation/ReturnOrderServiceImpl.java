package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.exceptions.OMS.OrderReturnApplyException;
import com.itsthatjun.ecommerce.mbg.mapper.OrderReturnApplyMapper;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnApply;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnApplyExample;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnReason;
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

    @Override
    public OrderReturnApply applyForReturn(OrderReturnApply apply, OrderReturnReason returnReason) {
        return null;
    }

    @Override
    public OrderReturnApply getStatus(OrderReturnApply apply) {
        return null;
    }
}
