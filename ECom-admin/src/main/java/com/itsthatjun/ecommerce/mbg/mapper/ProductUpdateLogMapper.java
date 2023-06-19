package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ProductUpdateLog;
import com.itsthatjun.ecommerce.mbg.model.ProductUpdateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductUpdateLogMapper {
    long countByExample(ProductUpdateLogExample example);

    int deleteByExample(ProductUpdateLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductUpdateLog record);

    int insertSelective(ProductUpdateLog record);

    List<ProductUpdateLog> selectByExample(ProductUpdateLogExample example);

    ProductUpdateLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductUpdateLog record, @Param("example") ProductUpdateLogExample example);

    int updateByExample(@Param("record") ProductUpdateLog record, @Param("example") ProductUpdateLogExample example);

    int updateByPrimaryKeySelective(ProductUpdateLog record);

    int updateByPrimaryKey(ProductUpdateLog record);
}