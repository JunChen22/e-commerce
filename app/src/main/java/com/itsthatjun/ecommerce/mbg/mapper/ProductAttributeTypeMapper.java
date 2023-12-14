package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ProductAttributeType;
import com.itsthatjun.ecommerce.mbg.model.ProductAttributeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductAttributeTypeMapper {
    long countByExample(ProductAttributeTypeExample example);

    int deleteByExample(ProductAttributeTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttributeType record);

    int insertSelective(ProductAttributeType record);

    List<ProductAttributeType> selectByExample(ProductAttributeTypeExample example);

    ProductAttributeType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductAttributeType record, @Param("example") ProductAttributeTypeExample example);

    int updateByExample(@Param("record") ProductAttributeType record, @Param("example") ProductAttributeTypeExample example);

    int updateByPrimaryKeySelective(ProductAttributeType record);

    int updateByPrimaryKey(ProductAttributeType record);
}