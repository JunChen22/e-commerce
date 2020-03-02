package com.example.spring.ecommerce.demo.controller;


import com.example.spring.ecommerce.demo.mapper.BrandMapper;
import com.example.spring.ecommerce.demo.model.Brand;
import com.example.spring.ecommerce.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    BrandMapper brandMapper;


    @GetMapping("/create")
    public ResponseEntity<?> create(){
        return new ResponseEntity<>("at brand create", HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public Iterable<Brand> listAllBrand(){
        return brandMapper.findAll();
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
