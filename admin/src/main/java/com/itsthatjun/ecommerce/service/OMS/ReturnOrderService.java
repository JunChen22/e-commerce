package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.dto.OMS.ReturnDetail;
import com.itsthatjun.ecommerce.dto.OMS.ReturnRequestDecision;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface ReturnOrderService {

    // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3

    @ApiOperation(value = "")
    List<ReturnRequest> getAllOpening();

    @ApiOperation(value = "")
    List<ReturnRequest> getAllReturning();

    @ApiOperation(value = "")
    List<ReturnRequest> getAllCompleted();

    @ApiOperation(value = "")
    List<ReturnRequest> getAllRejected();

    @ApiOperation(value = "")
    ReturnDetail getReturnDetail(String orderSn);

    @ApiOperation(value = "")
    ReturnRequest approveReturnRequest(ReturnRequestDecision returnRequestDecision, String operator);

    @ApiOperation(value = "")
    ReturnRequest rejectReturnRequest(ReturnRequestDecision returnRequestDecision, String reason, String operator);

    @ApiOperation(value = "")
    ReturnRequest completeReturnRequest(ReturnRequestDecision returnRequestDecision, String operator);

}
