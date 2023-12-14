package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.dto.SMS.UsedCouponHistory;
import com.itsthatjun.ecommerce.mbg.model.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponHistoryService {

    List<UsedCouponHistory> getAllCouponUsed();

    List<UsedCouponHistory> getUserCoupon(int id);
}
