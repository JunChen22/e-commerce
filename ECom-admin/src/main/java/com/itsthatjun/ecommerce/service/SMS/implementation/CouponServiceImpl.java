package com.itsthatjun.ecommerce.service.SMS.implementation;

import com.itsthatjun.ecommerce.exceptions.PMS.ProductException;
import com.itsthatjun.ecommerce.mbg.mapper.CouponMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ProductMapper;
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

    CouponMapper couponMapper;
    ProductMapper productMapper;

    @Autowired
    public CouponServiceImpl(CouponMapper couponMapper, ProductMapper productMapper) {
        this.couponMapper = couponMapper;
        this.productMapper = productMapper;
    }

    @Override
    public Coupon createCoupon(Coupon newCoupon) {
        int result = couponMapper.insert(newCoupon);
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
        return couponMapper.selectByExample(example);
    }

    @Override
    public Coupon getACoupon(int id) {
        return couponMapper.selectByPrimaryKey(id);
    }

    // -- discount on 0-> all, 1 -> specific brand, 2-> specific item
    @Override
    public List<Coupon> getCouponForProduct(int productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null)
            throw new ProductException("Can't find product : " + productId);

        String productName = product.getName();
        String brandName = product.getBrandName();

        System.out.println(productName + " " + brandName);
        CouponExample example = new CouponExample();
        // coupon that have product name, brand name, or all product in name
        example.createCriteria().andNameLike("%" + productName + "%");
        example.or().andNameLike("%" + brandName + "%");
        example.or().andNameLike("%" + "all product" + "%");
        example.or().andCouponTypeEqualTo(0);
        return couponMapper.selectByExample(example);
    }

    @Override
    public Coupon updateCoupon(Coupon updateCoupon) {
        CouponExample example = new CouponExample();
        example.createCriteria().andIdEqualTo(updateCoupon.getId());
        couponMapper.updateByExample(updateCoupon, example);
        return updateCoupon;
    }

    @Override
    public void deleteCoupon(int couponId) {
        couponMapper.deleteByPrimaryKey(couponId);
    }
}
