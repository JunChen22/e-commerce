package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.mbg.model.Coupon;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface CouponService {

    @ApiModelProperty("check coupon exist by coupon code")
    Coupon checkCoupon(String couponCode);

    @ApiModelProperty("Get All coupons that can apply to a product")
    List<Coupon> getCouponForProduct(int productId);

    @ApiModelProperty("update used coupon count and history")
    void updateUsedCoupon(String code, int orderId, int memberId);
}
