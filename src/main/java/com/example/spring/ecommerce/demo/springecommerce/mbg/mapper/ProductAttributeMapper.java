package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductAttribute;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductAttributeMapper {
    long countByExample(ProductAttributeExample example);

    int deleteByExample(ProductAttributeExample example);

    int insert(ProductAttribute record);

    int insertSelective(ProductAttribute record);

    List<ProductAttribute> selectByExample(ProductAttributeExample example);

    int updateByExampleSelective(@Param("record") ProductAttribute record, @Param("example") ProductAttributeExample example);

    int updateByExample(@Param("record") ProductAttribute record, @Param("example") ProductAttributeExample example);
}