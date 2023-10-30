package com.itsthatjun.ecommerce.dto;

import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ReturnParam implements Serializable {

    @ApiModelProperty("")
    private ReturnRequest returnRequest;

    @ApiModelProperty("")
    private Map<String, Integer> skuQuantity;

    @ApiModelProperty("")
    private List<ReturnReasonPictures> picturesList;
}
