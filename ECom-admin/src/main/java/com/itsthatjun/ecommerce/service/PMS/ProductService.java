package com.itsthatjun.ecommerce.service.PMS;

import com.itsthatjun.ecommerce.mbg.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();

    List<Product> listProduct(int pageNum, int pageSize);

    Product getProduct(int id);

    boolean createProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);
}
