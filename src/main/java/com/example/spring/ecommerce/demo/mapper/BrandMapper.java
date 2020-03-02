package com.example.spring.ecommerce.demo.mapper;

import com.example.spring.ecommerce.demo.model.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Select("SELECT *, name, category FROM brand")
    List<Brand> findAll();
}
