package com.example.spring.ecommerce.demo.controller;


import com.example.spring.ecommerce.demo.mapper.BrandMapper;
import com.example.spring.ecommerce.demo.model.Brand;
import com.example.spring.ecommerce.demo.service.BrandService;
import com.example.spring.ecommerce.demo.service.Impl.BrandServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandServiceImpl brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Brand brand){
        LOGGER.debug("createBrand success:{}",brand);
        brandService.createBrand(brand);
        return new ResponseEntity<>("at brand create", HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public Iterable<Brand> listAllBrand(){
        return brandService.listAllBrand();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Brand> listBrand(@PathVariable("id")  int id){
        return new ResponseEntity<>(brandService.getBrand(id), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable int id,@RequestBody Brand brand){
        return new ResponseEntity<>(brandService.updateBrand(id, brand), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable int id){
        brandService.deleteBrand(id);
        return new ResponseEntity<>("brand Successfully deleted", HttpStatus.CREATED);
    }

}
