package com.itsthatjun.ecommerce.controller.PMS;

import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.service.PMS.implementation.BrandServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@Api(tags = "Product related", description = "product management")
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
    @ApiOperation(value = "Get brands with page and size")
    public List<Brand> getAllBrand(@RequestParam(value = "page", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "size", defaultValue = "3") int pageSize){
        return brandService.listBrand(pageNum, pageSize);
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

    @PostMapping("/update/{id}")
    @ApiOperation(value = "Update a brand")
    public Brand updateBrand(@PathVariable int id, @RequestBody Brand brand){
        brandService.updateBrand(id, brand);
        return brand;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete a brand")
    public String deleteBrand(@PathVariable int id){
        brandService.deleteBrand(id);
        return "deleted";
    }
}
