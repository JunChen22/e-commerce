package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.OrderItem;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

public interface CouponService {

    // TODO: after security implement it, return discount amount based on shopping cart.
    @ApiOperation("Return discount amount based on item list")
    double checkDiscount(String couponCode, int userId);

    @ApiModelProperty("update used coupon count and history")
    void updateUsedCoupon(String code, int orderId, int userId);
}
