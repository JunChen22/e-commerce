package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.BrandUpdateLog;
import com.itsthatjun.ecommerce.mbg.model.BrandUpdateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandUpdateLogMapper {
    long countByExample(BrandUpdateLogExample example);

    int deleteByExample(BrandUpdateLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrandUpdateLog record);

    int insertSelective(BrandUpdateLog record);

    List<BrandUpdateLog> selectByExample(BrandUpdateLogExample example);

    BrandUpdateLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrandUpdateLog record, @Param("example") BrandUpdateLogExample example);

    int updateByExample(@Param("record") BrandUpdateLog record, @Param("example") BrandUpdateLogExample example);

    int updateByPrimaryKeySelective(BrandUpdateLog record);

    int updateByPrimaryKey(BrandUpdateLog record);
}