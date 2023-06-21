package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.CouponProductRelation;
import com.itsthatjun.ecommerce.mbg.model.CouponProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponProductRelationMapper {
    long countByExample(CouponProductRelationExample example);

    int deleteByExample(CouponProductRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponProductRelation record);

    int insertSelective(CouponProductRelation record);

    List<CouponProductRelation> selectByExample(CouponProductRelationExample example);

    CouponProductRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponProductRelation record, @Param("example") CouponProductRelationExample example);

    int updateByExample(@Param("record") CouponProductRelation record, @Param("example") CouponProductRelationExample example);

    int updateByPrimaryKeySelective(CouponProductRelation record);

    int updateByPrimaryKey(CouponProductRelation record);
}