package com.example.spring.ecommerce.demo.service.Impl;

import com.example.spring.ecommerce.demo.model.Brand;
import com.example.spring.ecommerce.demo.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public List<Brand> listAllBrand() {
        return null;
    }

    @Override
    public int createBrand(Brand brand) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, Brand brand) {
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public List<Brand> listBrand(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Brand getBrand(Long id) {
        return null;
    }
}
