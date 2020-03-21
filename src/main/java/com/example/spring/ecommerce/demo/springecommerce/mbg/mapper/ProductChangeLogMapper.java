package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductChangeLog;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductChangeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductChangeLogMapper {
    long countByExample(ProductChangeLogExample example);

    int deleteByExample(ProductChangeLogExample example);

    int insert(ProductChangeLog record);

    int insertSelective(ProductChangeLog record);

    List<ProductChangeLog> selectByExample(ProductChangeLogExample example);

    int updateByExampleSelective(@Param("record") ProductChangeLog record, @Param("example") ProductChangeLogExample example);

    int updateByExample(@Param("record") ProductChangeLog record, @Param("example") ProductChangeLogExample example);
}