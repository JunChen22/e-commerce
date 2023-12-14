package com.itsthatjun.ecommerce.dao.OMS;

import com.itsthatjun.ecommerce.dto.OMS.ReturnDetail;
import org.apache.ibatis.annotations.Param;
import io.swagger.annotations.ApiModelProperty;

public interface ReturnDao {

    @ApiModelProperty(value = "Get the order detail by order ID", example = "12345")
    ReturnDetail getDetail(@Param("orderSn") String orderSn);

}