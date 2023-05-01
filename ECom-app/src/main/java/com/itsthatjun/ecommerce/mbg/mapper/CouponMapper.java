package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.CouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);
}