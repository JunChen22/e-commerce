package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.Product;

import java.util.List;

public interface CouponService {
    Coupon createCoupon(Coupon newCoupon);

    List<Coupon> getAllCoupon();

    List<Coupon> getCouponForProduct(Product product);

    Coupon updateCoupon(Coupon updateCoupon);

    int deleteCoupon(Coupon coupon);
}
