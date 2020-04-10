package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductAttributeCategory;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductAttributeCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductAttributeCategoryMapper {
    long countByExample(ProductAttributeCategoryExample example);

    int deleteByExample(ProductAttributeCategoryExample example);

    int insert(ProductAttributeCategory record);

    int insertSelective(ProductAttributeCategory record);

    List<ProductAttributeCategory> selectByExample(ProductAttributeCategoryExample example);

    int updateByExampleSelective(@Param("record") ProductAttributeCategory record, @Param("example") ProductAttributeCategoryExample example);

    int updateByExample(@Param("record") ProductAttributeCategory record, @Param("example") ProductAttributeCategoryExample example);
}