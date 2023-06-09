package com.itsthatjun.ecommerce.dto.OMS;

import com.itsthatjun.ecommerce.mbg.model.OrderItem;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class OrderDetail extends Orders {

    @ApiModelProperty("order item list")
    private List<OrderItem> orderItemList;
}
