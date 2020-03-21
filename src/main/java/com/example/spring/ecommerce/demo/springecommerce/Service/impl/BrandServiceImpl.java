package com.example.spring.ecommerce.demo.springecommerce.Service.impl;

import com.example.spring.ecommerce.demo.springecommerce.Service.BrandService;
import com.example.spring.ecommerce.demo.springecommerce.mbg.mapper.BrandMapper;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Brand;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.BrandExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<Brand> listAllBrand() {
        return brandMapper.selectByExample(new BrandExample());
    }

    @Override
    public Brand getBrand(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean createBrand(Brand brand) {
        brandMapper.insert(brand);
        return true;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return false;
    }

    @Override
    public boolean deleteBrand(int id) {
        return false;
    }
}
