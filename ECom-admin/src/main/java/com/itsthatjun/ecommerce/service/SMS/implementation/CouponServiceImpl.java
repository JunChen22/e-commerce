package com.itsthatjun.ecommerce.service.SMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.CouponMapper;
import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.CouponExample;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.service.SMS.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
public class CouponServiceImpl implements CouponService {

    CouponMapper mapper;

    @Autowired
    public CouponServiceImpl(CouponMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Coupon createCoupon(Coupon newCoupon) {
        int result = mapper.insert(newCoupon);
        if(result > 0) {
            System.out.println("coupon added successfully");
        } else {
            System.out.println("unable to add coupon");
        }
        return newCoupon;
    }

    @Override
    public List<Coupon> getAllCoupon() {
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        CouponExample example = new CouponExample();
        example.createCriteria().andEndTimeGreaterThan(date);
        return mapper.selectByExample(example);
    }

    @Override
    public List<Coupon> getCouponForProduct(Product product) {
        String productName = product.getName();
        String brandName = product.getBrandName();
        CouponExample example = new CouponExample();
        // coupon that have product name, brand name, or all product in name
        example.createCriteria().andNameLike("%" + productName + "%");
        example.or().andNameLike("%" + brandName + "%");
        example.or().andNameLike("%" + "all product" + "%");
        return mapper.selectByExample(example);
    }

    @Override
    public Coupon updateCoupon(Coupon updateCoupon) {
        CouponExample example = new CouponExample();
        example.createCriteria().andIdEqualTo(updateCoupon.getId());
        mapper.updateByExample(updateCoupon, example);
        return updateCoupon;
    }

    @Override
    public int deleteCoupon(Coupon coupon) {
        CouponExample example = new CouponExample();
        example.createCriteria().andIdEqualTo(coupon.getId());
        int result = mapper.deleteByExample(example);
        return result;
    }
}
