package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.CouponHistory;
import com.itsthatjun.ecommerce.mbg.model.CouponHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponHistoryMapper {
    long countByExample(CouponHistoryExample example);

    int deleteByExample(CouponHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponHistory record);

    int insertSelective(CouponHistory record);

    List<CouponHistory> selectByExample(CouponHistoryExample example);

    CouponHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponHistory record, @Param("example") CouponHistoryExample example);

    int updateByExample(@Param("record") CouponHistory record, @Param("example") CouponHistoryExample example);

    int updateByPrimaryKeySelective(CouponHistory record);

    int updateByPrimaryKey(CouponHistory record);
}