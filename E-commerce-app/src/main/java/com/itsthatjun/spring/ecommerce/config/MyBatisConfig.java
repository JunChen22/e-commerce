package com.itsthatjun.spring.ecommerce.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.example.spring.ecommerce.demo.springecommerce.dao",
             "com.example.spring.ecommerce.demo.springecommerce.mbg.mapper"})
public class MyBatisConfig {
    // creates the mapper bean
}
