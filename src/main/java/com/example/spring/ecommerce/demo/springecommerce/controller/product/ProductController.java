package com.example.spring.ecommerce.demo.springecommerce.controller.product;

import com.example.spring.ecommerce.demo.springecommerce.Service.impl.AdminServiceImpl;
import com.example.spring.ecommerce.demo.springecommerce.Service.impl.ProductServiceImpl;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAllproduct(){
        List<Product> products = productService.getAllProduct();
        return products;
    }
}
