package com.example.spring.ecommerce.demo.controller;


import com.example.spring.ecommerce.demo.mapper.BrandMapper;
import com.example.spring.ecommerce.demo.model.Brand;
import com.example.spring.ecommerce.demo.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Brand brand){
        LOGGER.debug("createBrand success:{}",brand);
        return new ResponseEntity<>("at brand create", HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public Iterable<Brand> listAllBrand(){
        return null;
    }

    /*
    public ResponseEntity<?> updateBrand(){

    }
    public ResponseEntity<?> deleteBrand(){

    }

    public ResponseEntity<?> listBrand(){

    }
    */
}
