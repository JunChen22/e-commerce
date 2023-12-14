package com.itsthatjun.ecommerce.service.PMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.mbg.mapper.ProductMapper;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.ProductExample;
import com.itsthatjun.ecommerce.service.PMS.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> listAllProduct() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public List<Product> listProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public Product getProduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean createProduct(Product product) {
        productMapper.insert(product);
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        productMapper.deleteByPrimaryKey(id);
        return true;
    }
}
