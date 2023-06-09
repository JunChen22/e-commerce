package com.itsthatjun.ecommerce.service;

import com.itsthatjun.ecommerce.mbg.model.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> listAllBrand();

    List<Brand> listBrand(int pageNum, int pageSize);

    Brand getBrand(int id);

    boolean createBrand(Brand brand);

    boolean updateBrand(int id, Brand brand);

    boolean deleteBrand(int id);
}
