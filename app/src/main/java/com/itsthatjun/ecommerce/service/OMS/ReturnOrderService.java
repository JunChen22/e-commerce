package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

public interface ReturnOrderService {

    // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3
    @ApiOperation(value = "view return apply status, approve/reject")
    ReturnRequest getStatus(String orderSn, int userId);

    @ApiOperation(value = "apply for return, waiting for admin approve/reject")
    ReturnRequest applyForReturn(ReturnRequest returnRequest, List<ReturnReasonPictures> picturesList, Map<String, Integer> skuQuantity, int userId);

    @ApiOperation(value = "update or add in more info for return")
    ReturnRequest updateReturnInfo(ReturnRequest returnRequest, List<ReturnReasonPictures> picturesList, String orderSn, int userId);

    @ApiOperation(value = "cancel the return request")
    ReturnRequest cancelReturn(String orderSn, int userId);

    @ApiOperation(value = "automatically reject after a set time, not review by admin")
    ReturnRequest delayedRejectReturn(String orderSn, int userId);
}
