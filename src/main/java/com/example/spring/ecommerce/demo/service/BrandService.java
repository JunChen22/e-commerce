package com.example.spring.ecommerce.demo.service;

import com.example.spring.ecommerce.demo.model.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> listAllBrand();

    int createBrand(Brand brand);

    int updateBrand(Long id, Brand brand);

    int deleteBrand(Long id);

    List<Brand> listBrand(int pageNum, int pageSize);

    Brand getBrand(Long id);
}
