package com.itsthatjun.ecommerce.service.PMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.mbg.mapper.BrandMapper;
import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.mbg.model.BrandExample;
import com.itsthatjun.ecommerce.service.PMS.BrandService;
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
    public List<Brand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
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
    public boolean updateBrand(int id, Brand brand) {
        brand.setId(id);
        brandMapper.updateByPrimaryKeySelective(brand);
        return true;
    }

    @Override
    public boolean deleteBrand(int id) {
        brandMapper.deleteByPrimaryKey(id);
        return true;
    }
}
