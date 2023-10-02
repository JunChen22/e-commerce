package com.itsthatjun.ecommerce.dto.OMS;

import com.itsthatjun.ecommerce.mbg.model.Address;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class ConfirmOrderResult {

    // generate the final cost of order before actual transaction

    @ApiModelProperty("item in shopping cart")
    private List<CartItem> cartItemList;

    @ApiModelProperty("Member deliver address")
    private Address address;

    @ApiModelProperty("coupon for discount")
    private String coupon;

    @ApiModelProperty("paypal, g pay, or finance. currently just paypal")
    private Integer payType;

    private double totalPrice;
    private double couponDiscount;
    private double shippingCost;
    private double payAmount;
}
