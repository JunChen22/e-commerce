package com.itsthatjun.ecommerce.dto.OMS;

import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.mbg.model.ShoppingCart;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class OrderParam {

    @ApiModelProperty("item in shopping cart")
    private List<CartItem> cartItemList;

    @ApiModelProperty("Member deliver address")
    private ReceiveAddress address;

    @ApiModelProperty("coupon for discount")
    private String coupon;

    //@ApiModelProperty("paypal, g pay, or finance. currently just paypal")
    //private Integer payType;
}
