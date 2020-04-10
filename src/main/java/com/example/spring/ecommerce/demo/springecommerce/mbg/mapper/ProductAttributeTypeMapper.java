package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductAttributeType;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductAttributeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductAttributeTypeMapper {
    long countByExample(ProductAttributeTypeExample example);

    int deleteByExample(ProductAttributeTypeExample example);

    int insert(ProductAttributeType record);

    int insertSelective(ProductAttributeType record);

    List<ProductAttributeType> selectByExample(ProductAttributeTypeExample example);

    int updateByExampleSelective(@Param("record") ProductAttributeType record, @Param("example") ProductAttributeTypeExample example);

    int updateByExample(@Param("record") ProductAttributeType record, @Param("example") ProductAttributeTypeExample example);
}