package com.itsthatjun.ecommerce.dao;

import com.itsthatjun.ecommerce.domainmodel.ProductDetail;
import com.itsthatjun.ecommerce.mbg.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    // get one
    Product getProduct(@Param("id") Long id);
    // get a list
    List<Product> getAllProduct();

    // one with a list
    ProductDetail getProductWithAtrribute(@Param("id") Long id);

    // list with a list
    List<ProductDetail> getProductListWithAtrribute();

    // update one
    void updateProduct(@Param("id") Long id, @Param("stock") int stock);

    // update all
    void updateProductList(@Param("productList") List<Product> productDetailList);

    // add/insert one
    void insertProduct(@Param("product") Product product);

    // add a list
    void insertProductList(@Param("productList") List<Product> productList);

    // delete one
    void deleteProduct(@Param("id") Long id);

    // delete all
    void deleteProductList(@Param("productList") List<Product> productList);
}
