package com.itsthatjun.ecommerce.controller.PMS;

import com.itsthatjun.ecommerce.dto.CMS.Articles;
import com.itsthatjun.ecommerce.mbg.mapper.ProductMapper;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.ProductExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product/test")
@Api(tags = "Product related", description = "testing the MyBatis Generator generated mapper and example. Example that comes with mapper are SQL methods." +
        "selective means only updates the already have data")
public class TestProductController2 {

    private final ProductMapper productMapper;

    @Autowired
    public TestProductController2(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @GetMapping("/countByExample")
    @ApiOperation(value = "Returns the count of rows in the database that match the specified example")
    public long countByExample() {
        ProductExample example = new ProductExample();
        example.createCriteria().andOriginalPriceLessThan(BigDecimal.valueOf(200));
        long numProductLessThan = productMapper.countByExample(example);
        System.out.println(numProductLessThan + " of products less than 200");
        return numProductLessThan;
    }

    @DeleteMapping("/deleteByExample/{name}")
    @ApiOperation(value = "deletes rows in the database that match the specified example")
    public void deleteByExample(@PathVariable String name) {
        ProductExample example = new ProductExample();
        example.createCriteria().andNameEqualTo(name);
        productMapper.deleteByExample(example);
    }

    @DeleteMapping("/deleteByPrimaryKey/{id}")
    @ApiOperation(value = "Deletes the row in the database with the specified primary key.")
    public void deleteByPrimaryKey(@PathVariable int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Inserts a new row in the database with the specified product data")
    public Product insert(@RequestBody Product product) {
        product.setId(69);
        productMapper.insert(product);
        return product;
    }

    @PostMapping("/insertSelective")
    @ApiOperation(value = "Inserts a new row in the database with the specified product data, but only for the columns that are not null.")
    public void insertSelective(Product product) {
        product.setId(69);
        productMapper.insertSelective(product);
    }

    @GetMapping("/selectByExample/{amount}")
    @ApiOperation(value = "Returns a list of products from the database that match the specified example.")
    public List<Product> selectByExample(@PathVariable double amount) {
        ProductExample example = new ProductExample();
        example.createCriteria().andOriginalPriceLessThan(BigDecimal.valueOf(amount));
        return productMapper.selectByExample(example);
    }

    @GetMapping("/selectByPrimaryKey/{id}")
    @ApiOperation(value = "Returns the product from the database with the specified primary key. Example usage:")
    public Product selectByPrimaryKey(@PathVariable int id) {
        Product foundProduct = productMapper.selectByPrimaryKey(id);
        System.out.println("found product " + foundProduct.getId() + " " + foundProduct.getName());
        return foundProduct;
    }

    @PostMapping("/updateByExampleSelective")
    @ApiOperation(value = "Updates the rows in the database that match the specified example with the specified product data, " +
                          "but only for the columns that are not null.")
    public void updateByExampleSelective(@RequestBody Product productToUpdate) {
        ProductExample example = new ProductExample();
        example.createCriteria().andNameEqualTo("testphone");  // find product with name testphone
        productMapper.updateByExampleSelective(productToUpdate, example); // update product name with testphone to the producToUpdate
    }

    @PostMapping("/updateByExample")
    @ApiOperation(value = "Updates the rows in the database that match the specified example with the specified product data.")
    public void updateByExample(@RequestBody Product product) {
        ProductExample example = new ProductExample();
        example.createCriteria().andNameEqualTo("apple"); // find the row that wanted to change
        productMapper.updateByExample(product, example);
    }

    @PostMapping("/updateByPrimaryKeySelective")
    @ApiOperation(value = "Updates the row in the database with the specified primary key with the specified product data, " +
            "              but only for the columns that are not null")
    public void updateByPrimaryKeySelective(@RequestBody Product product) {
        int result = productMapper.updateByPrimaryKey(product); // will find the product by the primary key, update if found.
        if(result > 0) {
            System.out.println("found and updated " + result + " products");
        } else {
            System.out.println("can not find any product with the primary key" + product.getId());
        }
    }

    @PostMapping("/updateByPrimaryKey")
    @ApiOperation(value = "Update the record identified by the primary key of the given object, updating all fields.")
    public void updateByPrimaryKey(@RequestBody Product product) {
        int result = productMapper.updateByPrimaryKey(product); // will find the product by the primary key, update if found.
        if(result > 0) {
            System.out.println("found and updated " + result + " products");
        } else {
            System.out.println("can not find any product with the primary key" + product.getId());
        }
    }
}
