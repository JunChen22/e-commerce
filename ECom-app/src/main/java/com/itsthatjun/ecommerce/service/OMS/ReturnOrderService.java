package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

public interface ReturnOrderService {

    @ApiOperation(value = "view return apply status, approve/reject")
    ReturnRequest getStatus(String orderSn, int userId);

    @ApiOperation(value = "apply for return, waiting for admin approve/reject")
    ReturnRequest applyForReturn(ReturnRequest returnRequest, List<ReturnReasonPictures> picturesList, Map<String, Integer> skuQuantity, int userId );

    @ApiOperation(value = "update or add in more info for return")
    ReturnRequest updateReturnInfo(ReturnRequest returnRequest, List<ReturnReasonPictures> picturesList, String orderSn, int userId);

    @ApiOperation(value = "cancel the return request")
    ReturnRequest cancelReturn(String orderSn, int userId);
}
