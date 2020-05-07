package com.example.spring.ecommerce.demo.springecommerce.controller.product;

import com.example.spring.ecommerce.demo.springecommerce.Service.impl.BrandServiceImpl;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@Api(value = " title", tags = {"brands", " GET and POST"})
public class BrandController {

    private final BrandServiceImpl brandService;

    @Autowired
    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/listAll")
    @ApiOperation(value = "Get all brands")
    public List<Brand> getAllBrand(){
        return brandService.listAllBrand();
    }

    @GetMapping("/list")
    @ApiOperation(value = "Get all brands")
    public List<Brand> getBrand(){
        return brandService.listAllBrand();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get brand by id")
    public Brand getBrand(@PathVariable int id){
        return brandService.getBrand(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a brand")
    public Brand createBrand(@RequestBody Brand brand){
        brandService.createBrand(brand);
        return brand;
    }

    @PostMapping("/update")
    @ApiOperation(value = "update a brand")
    public Brand updateBrand(@RequestBody Brand brand){
        brandService.createBrand(brand);
        return brand;
    }
    @PostMapping("/delete")
    @ApiOperation(value = "delete a brand")
    public Brand deleteBrand(@RequestBody Brand brand){
        brandService.createBrand(brand);
        return brand;
    }
}
