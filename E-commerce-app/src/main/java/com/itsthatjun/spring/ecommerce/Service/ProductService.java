package com.itsthatjun.spring.ecommerce.Service;

import com.itsthatjun.spring.ecommerce.mbg.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();

    List<Product> listProduct(int pageNum, int pageSize);

    Product getProduct(int id);

    boolean createProduct(Product product);

    boolean updateProduct(int id, Product product);

    boolean deleteProduct(int id);
}
