package com.itsthatjun.ecommerce.dto.OMS;

import com.itsthatjun.ecommerce.mbg.model.ReturnLog;
import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ReturnDetail {

    @ApiModelProperty("")
    private ReturnRequest returnRequest;

    @ApiModelProperty("")
    private List<ReturnReasonPictures> picturesList;

    @ApiModelProperty("")
    private List<ReturnLog> logList;
}