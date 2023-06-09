package com.itsthatjun.ecommerce.dao.PMS;

import com.itsthatjun.ecommerce.dto.PMS.ProductDetail;
import com.itsthatjun.ecommerce.mbg.model.Product;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    @ApiModelProperty(value = "get one")
    Product getProduct(@Param("id") int id);

    @ApiModelProperty(value = "get a list")
    List<Product> getAllProduct();

    @ApiModelProperty(value = "one with a list")
    ProductDetail getProductWithAtrribute(@Param("id") int id);

    @ApiModelProperty(value = "list with a list")
    List<ProductDetail> getProductListWithAtrribute();

    @ApiModelProperty(value = "update one")
    void updateProduct(@Param("id") int id, @Param("stock") int stock);

    @ApiModelProperty(value = "update all")
    void updateProductList(@Param("productList") List<Product> productDetailList);

    @ApiModelProperty(value = "add/insert one")
    void insertProduct(@Param("product") Product product);

    @ApiModelProperty(value = "add a list")
    void insertProductList(@Param("productList") List<Product> productList);

    @ApiModelProperty(value = "delete one")
    void deleteProduct(@Param("id") int id);

    @ApiModelProperty(value = "delete all")
    void deleteProductList(@Param("productList") List<Product> productList);
}