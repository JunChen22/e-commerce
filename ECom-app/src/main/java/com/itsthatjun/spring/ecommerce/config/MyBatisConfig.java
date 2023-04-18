package com.itsthatjun.spring.ecommerce.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.itsthatjun.spring.ecommerce.dao",
             "com.itsthatjun.spring.ecommerce.mbg.mapper"})
public class MyBatisConfig {
    // creates the mapper bean
}
