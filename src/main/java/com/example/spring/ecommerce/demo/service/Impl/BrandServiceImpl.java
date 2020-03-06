package com.example.spring.ecommerce.demo.service.Impl;

import com.example.spring.ecommerce.demo.mapper.BrandMapper;
import com.example.spring.ecommerce.demo.model.Brand;
import com.example.spring.ecommerce.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<Brand> listAllBrand() {
        return brandMapper.findAll();
    }

    @Override
    public int createBrand(Brand brand) {
        brandMapper.saveBrand(brand);
        return 1;
    }

    @Override
    public int updateBrand(int id, Brand brand) {
        brand.setId(id);
        brandMapper.updateBrand(brand);
        return 1;
    }

    @Override
    public void deleteBrand(int id) {
        brandMapper.deleteBrand(id);
    }

    @Override
    public List<Brand> listBrand(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Brand getBrand(int id) {
        return brandMapper.findById(id);
    }
}
