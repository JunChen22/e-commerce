package com.example.spring.ecommerce.demo.springecommerce.Service;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Brand;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();

    List<Product> listProduct(int pageNum, int pageSize);

    Product getProduct(int id);

    boolean createProduct(Product product);

    boolean updateProduct(int id, Product product);

    boolean deleteProduct(int id);
}
