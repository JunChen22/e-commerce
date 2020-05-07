package com.example.spring.ecommerce.demo.springecommerce.Service.impl;

import com.example.spring.ecommerce.demo.springecommerce.Service.ProductService;
import com.example.spring.ecommerce.demo.springecommerce.mbg.mapper.ProductMapper;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Product;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ProductExample;
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
    public List<Product> getAllProduct() {
        return productMapper.selectByExample(new ProductExample());
    }
}
