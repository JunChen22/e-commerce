package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.OrderReturnApply;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnReason;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface ReturnOrderService {

    @ApiModelProperty(value = "apply for return, waiting for admin approve/reject")
    OrderReturnApply applyForReturn(OrderReturnApply apply, OrderReturnReason returnReason);

    @ApiModelProperty(value = "view return apply status, approve/reject")
    OrderReturnApply getStatus(OrderReturnApply apply);
}
