package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ProductAttributeCategory;
import com.itsthatjun.ecommerce.mbg.model.ProductAttributeCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductAttributeCategoryMapper {
    long countByExample(ProductAttributeCategoryExample example);

    int deleteByExample(ProductAttributeCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttributeCategory record);

    int insertSelective(ProductAttributeCategory record);

    List<ProductAttributeCategory> selectByExample(ProductAttributeCategoryExample example);

    ProductAttributeCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductAttributeCategory record, @Param("example") ProductAttributeCategoryExample example);

    int updateByExample(@Param("record") ProductAttributeCategory record, @Param("example") ProductAttributeCategoryExample example);

    int updateByPrimaryKeySelective(ProductAttributeCategory record);

    int updateByPrimaryKey(ProductAttributeCategory record);
}