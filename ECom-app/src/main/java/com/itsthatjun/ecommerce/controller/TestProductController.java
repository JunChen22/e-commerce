package com.itsthatjun.ecommerce.controller;

import com.itsthatjun.ecommerce.dao.ProductDao;
import com.itsthatjun.ecommerce.domainmodel.ProductDetail;
import com.itsthatjun.ecommerce.mbg.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/test")
@Api(tags = "Product related", description = "simple API using custom DAO and SQL quires")
public class TestProductController {

    private final ProductDao productDao;

    @Autowired
    public TestProductController(ProductDao productDao) {
        this.productDao = productDao;
    }


    @GetMapping("/getProduct/{id}")
    @ApiOperation(value = "Get product")
    public Product getProduct(@PathVariable Long id) {
        return productDao.getProduct(id);
    }

    // get a list
    @GetMapping("/getAllProduct")
    @ApiOperation(value = "Get all product")
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    // one with a list
    @GetMapping("/getProductWithAtrribute/{id}")
    @ApiOperation(value = "Get product with attribute")
    public ProductDetail getProductWithAtrribute(@PathVariable Long id) {
        return productDao.getProductWithAtrribute(id);
    }

    // list with a list
    @GetMapping("/getProductListWithAtrribute")
    @ApiOperation(value = "Get all product with attribute")
    public List<ProductDetail> getProductListWithAtrribute() {
        return productDao.getProductListWithAtrribute();
    }

    @PostMapping("/updateProduct/{id}")
    @ApiOperation(value = "update a product stock")
    public void updateProduct(@PathVariable Long id) {
        productDao.updateProduct(id, 2);
    };

    // update all
    @PostMapping("/updateProductList")
    @ApiOperation(value = "update all product stock")
    public void updateProductList(@RequestBody List<Product> productList) {
        productDao.updateProductList(productList);
    };

    // add/insert one
    @PostMapping("/insertProduct")
    @ApiOperation(value = "Insert a product")
    public void insertProduct(@RequestBody Product product) {
        productDao.insertProduct(product);
    };

    // add a list
    @PostMapping("/insertProductList")
    @ApiOperation(value = "insert a list of  product")
    public void insertProductList(@RequestBody List<Product> productList) {
        productDao.insertProductList(productList);
    };

    // delete one
    @DeleteMapping("/deleteProduct/{id}")
    @ApiOperation(value = "Delete a  product")
    public void deleteProduct(@PathVariable Long id) {
        productDao.deleteProduct(id);
    };

    // delete all
    @DeleteMapping("/deleteProductList")
    @ApiOperation(value = "Delete a list of product")
    public void deleteProductList(@RequestBody List<Product> productList) {
        productDao.deleteProductList(productList);
    };
}
