package com.itsthatjun.ecommerce.controller.PMS;

import com.itsthatjun.ecommerce.dao.PMS.ProductDao;
import com.itsthatjun.ecommerce.dto.PMS.ProductDetail;
import com.itsthatjun.ecommerce.mbg.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/test")
@Api(tags = "Product related", description = "simple API using custom DAO and SQL quires. Cover most of the needed queries")
public class TestProductController {

    private final ProductDao productDao;

    @Autowired
    public TestProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/getProduct/{id}")
    @ApiOperation(value = "Get product")
    public Product getProduct(@PathVariable int id) {
        return productDao.getProduct(id);
    }

    @GetMapping("/getAllProduct")
    @ApiOperation(value = "Get all product")
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @GetMapping("/getProductWithAtrribute/{id}")
    @ApiOperation(value = "Get product with attribute")
    public ProductDetail getProductWithAtrribute(@PathVariable int id) {
        return productDao.getProductWithAtrribute(id);
    }

    @GetMapping("/getProductListWithAtrribute")
    @ApiOperation(value = "Get all product with attribute")
    public List<ProductDetail> getProductListWithAtrribute() {
        return productDao.getProductListWithAtrribute();
    }

    @PostMapping("/updateProduct/{id}")
    @ApiOperation(value = "update a product stock")
    public void updateProduct(@PathVariable int id) {
        productDao.updateProduct(id, 2);
    };

    @PostMapping("/updateProductList")
    @ApiOperation(value = "update all product stock")
    public void updateProductList(@RequestBody List<Product> productList) {
        productDao.updateProductList(productList);
    };

    @PostMapping("/insertProduct")
    @ApiOperation(value = "Insert a product")
    public void insertProduct(@RequestBody Product product) {
        productDao.insertProduct(product);
    };

    @PostMapping("/insertProductList")
    @ApiOperation(value = "insert a list of  product")
    public void insertProductList(@RequestBody List<Product> productList) {
        productDao.insertProductList(productList);
    };

    @DeleteMapping("/deleteProduct/{id}")
    @ApiOperation(value = "Delete a  product")
    public void deleteProduct(@PathVariable int id) {
        productDao.deleteProduct(id);
    };

    @DeleteMapping("/deleteProductList")
    @ApiOperation(value = "Delete a list of product")
    public void deleteProductList(@RequestBody List<Product> productList) {
        productDao.deleteProductList(productList);
    };
}
