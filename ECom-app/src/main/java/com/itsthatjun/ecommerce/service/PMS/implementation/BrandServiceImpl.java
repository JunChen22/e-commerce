package com.itsthatjun.ecommerce.service.PMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.mbg.mapper.BrandMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ProductMapper;
import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.mbg.model.BrandExample;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.ProductExample;
import com.itsthatjun.ecommerce.service.PMS.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final ProductMapper productMapper;

    private final BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(ProductMapper productMapper, BrandMapper brandMapper) {
        this.productMapper = productMapper;
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
    public List<Product> listAllBrandProduct(int brandId) {
        ProductExample example = new ProductExample();
        example.createCriteria().andBrandIdEqualTo(brandId);
        List<Product> brandProducts = productMapper.selectByExample(example);
        return brandProducts;
    }

    @Override
    public Brand getBrand(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }

}
