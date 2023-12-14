package com.itsthatjun.ecommerce.dto.SMS;

import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.CouponHistory;
import lombok.Data;

import java.util.List;

@Data
public class UsedCouponHistory {

    private Coupon coupon;
    private List<CouponHistory> couponHistoryList;

}
