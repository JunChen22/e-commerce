package com.itsthatjun.ecommerce.controller.PMS;

import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.service.PMS.implementation.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Api(tags = "Product related")
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/listAll")
    @ApiOperation(value = "Get all product")
    public List<Product> listAllProduct(){
        List<Product> productList = productService.listAllProduct();
        return productList;
    }

    @GetMapping("/list")
    @ApiOperation(value = "Get product with page and size")
    public List<Product> listAllProduct(@RequestParam(value = "page", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "size", defaultValue = "5") int pageSize){
        return productService.listProduct(pageNum, pageSize);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product by id")
    public Product listProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a product")
    //@PreAuthorize("hasAuthority('product:create')")
    public Product createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return product;
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update a product")
    //@PreAuthorize("hasAuthority('product:update')")
    public Product updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return product;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete a product")
    //@PreAuthorize("hasAuthority('product:delete')")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "deleted";
    }
}
