package com.itsthatjun.ecommerce.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.itsthatjun.spring.ecommerce.dao",
             "com.example.spring.ecommerce.demo.springecommerce.mbg.mapper"})
public class MyBatisConfig {
    // creates the mapper bean
}
