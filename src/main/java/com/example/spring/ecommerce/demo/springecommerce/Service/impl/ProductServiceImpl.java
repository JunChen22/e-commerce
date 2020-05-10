package com.example.spring.ecommerce.demo.springecommerce.Service.impl;

import com.example.spring.ecommerce.demo.springecommerce.Service.ProductService;
import com.example.spring.ecommerce.demo.springecommerce.mbg.mapper.ProductMapper;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Brand;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Product;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductExample;
import com.github.pagehelper.PageHelper;
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
    public boolean updateProduct(int id, Product product) {
        product.setId(id);
        productMapper.updateByPrimaryKeySelective(product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        productMapper.deleteByPrimaryKey(id);
        return true;
    }
}
