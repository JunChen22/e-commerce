package com.itsthatjun.ecommerce.Service;

import com.itsthatjun.ecommerce.mbg.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();

    List<Product> listProduct(int pageNum, int pageSize);

    Product getProduct(Long id);

    boolean createProduct(Product product);

    boolean updateProduct(Long id, Product product);

    boolean deleteProduct(Long id);
}
