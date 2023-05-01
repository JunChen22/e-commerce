package com.itsthatjun.ecommerce.domainmodel;

import com.itsthatjun.ecommerce.mbg.model.OrderItem;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class OrderDetail extends Orders {

    @ApiModelProperty("order item list")
    private List<OrderItem> orderItemList;
}
