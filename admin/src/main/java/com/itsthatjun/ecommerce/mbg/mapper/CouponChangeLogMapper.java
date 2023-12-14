package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.CouponChangeLog;
import com.itsthatjun.ecommerce.mbg.model.CouponChangeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponChangeLogMapper {
    long countByExample(CouponChangeLogExample example);

    int deleteByExample(CouponChangeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponChangeLog record);

    int insertSelective(CouponChangeLog record);

    List<CouponChangeLog> selectByExample(CouponChangeLogExample example);

    CouponChangeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponChangeLog record, @Param("example") CouponChangeLogExample example);

    int updateByExample(@Param("record") CouponChangeLog record, @Param("example") CouponChangeLogExample example);

    int updateByPrimaryKeySelective(CouponChangeLog record);

    int updateByPrimaryKey(CouponChangeLog record);
}