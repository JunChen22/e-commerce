package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.Product;

import java.util.List;

public interface CouponService {
    Coupon createCoupon(Coupon newCoupon);

    List<Coupon> getAllCoupon();

    Coupon getACoupon(int id);

    List<Coupon> getCouponForProduct(int productId);

    Coupon updateCoupon(Coupon updateCoupon);

    void deleteCoupon(int couponId);
}
