package com.itsthatjun.ecommerce.service.SMS.implementation;

import com.itsthatjun.ecommerce.dto.SMS.UsedCouponHistory;
import com.itsthatjun.ecommerce.mbg.mapper.CouponHistoryMapper;
import com.itsthatjun.ecommerce.mbg.mapper.CouponMapper;
import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.CouponExample;
import com.itsthatjun.ecommerce.mbg.model.CouponHistory;
import com.itsthatjun.ecommerce.mbg.model.CouponHistoryExample;
import com.itsthatjun.ecommerce.service.SMS.CouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CouponHistoryServiceImpl implements CouponHistoryService {

    CouponHistoryMapper couponHistoryMapper;
    CouponMapper couponMapper;

    @Autowired
    public CouponHistoryServiceImpl(CouponHistoryMapper couponHistoryMapper, CouponMapper couponMapper) {
        this.couponHistoryMapper = couponHistoryMapper;
        this.couponMapper = couponMapper;
    }

    @Override
    public List<UsedCouponHistory> getAllCouponUsed() {
        List<Coupon> couponList = couponMapper.selectByExample(new CouponExample());  // getting all coupon types
        List<UsedCouponHistory> result = new ArrayList<>();

        for(Coupon coupon : couponList) {
            CouponHistoryExample example = new CouponHistoryExample();
            example.createCriteria().andCouponIdEqualTo(coupon.getId());
            List<CouponHistory> couponHistoryList = couponHistoryMapper.selectByExample(example);
            UsedCouponHistory current = new UsedCouponHistory();
            current.setCoupon(coupon);
            current.setCouponHistoryList(couponHistoryList);
            result.add(current);
        }
        // TODO: make it user count, now it's not right
        //       change it to use custom dao
        return result;
    }

    @Override
    public List<UsedCouponHistory> getUserCoupon(int id) {
        // TODO: fix the coupon history
        List<Coupon> couponList = couponMapper.selectByExample(new CouponExample());  // getting all coupon types
        List<UsedCouponHistory> result = new ArrayList<>();
        for(Coupon coupon : couponList) {
            CouponHistoryExample example = new CouponHistoryExample();
            example.createCriteria().andCouponIdEqualTo(coupon.getId());
            example.createCriteria().andMemberIdEqualTo(id);
            List<CouponHistory> couponHistoryList = couponHistoryMapper.selectByExample(example);
            UsedCouponHistory current = new UsedCouponHistory();
            current.setCoupon(coupon);
            current.setCouponHistoryList(couponHistoryList);
            result.add(current);
        }
        return result;
    }
}
