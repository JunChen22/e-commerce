package com.itsthatjun.ecommerce.controller.SMS;

import com.itsthatjun.ecommerce.dto.SMS.UsedCouponHistory;
import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.service.SMS.CouponHistoryService;
import com.itsthatjun.ecommerce.service.SMS.implementation.CouponHistoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coupon")
@Api(tags = "Coupon related", description = "CRUD coupon by admin with right roles/permission")
public class CouponHistoryController {

    private final CouponHistoryServiceImpl couponHistoryService;

    @Autowired
    public CouponHistoryController(CouponHistoryServiceImpl couponHistoryService) {
        this.couponHistoryService = couponHistoryService;
    }

    @GetMapping("/getAllUsedCoupon")
    @ApiOperation(value = "return all the coupon used between two time")
    public List<UsedCouponHistory> couponUsed() {
        // TODO: add default value for the two times, currently all used coupons
        return couponHistoryService.getAllCouponUsed();
    };

    @GetMapping("/getUserCoupon/{userId}")
    @ApiOperation(value = "shows how many coupon(amount saved) a user used")
    public List<UsedCouponHistory> getUserCoupon(@PathVariable int userId) {
        return couponHistoryService.getUserCoupon(userId);
    }
}
