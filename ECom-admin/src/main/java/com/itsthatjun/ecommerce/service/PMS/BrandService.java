package com.itsthatjun.ecommerce.service.PMS;

import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.mbg.model.Product;

import java.util.List;

public interface BrandService {

    List<Brand> listAllBrand();

    List<Brand> listBrand(int pageNum, int pageSize);

    List<Product> listAllBrandProduct(int brandId);
    Brand getBrand(int id);

    boolean createBrand(Brand brand);

    boolean updateBrand(Brand brand);

    boolean deleteBrand(int id);
}
