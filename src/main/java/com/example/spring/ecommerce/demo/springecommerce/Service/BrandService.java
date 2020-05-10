package com.example.spring.ecommerce.demo.springecommerce.Service;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> listAllBrand();

    List<Brand> listBrand(int pageNum, int pageSize);

    Brand getBrand(int id);

    boolean createBrand(Brand brand);

    boolean updateBrand(int id, Brand brand);

    boolean deleteBrand(int id);
}
