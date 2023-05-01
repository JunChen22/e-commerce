package com.itsthatjun.ecommerce.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.itsthatjun.ecommerce.dao",
             "com.itsthatjun.ecommerce.mbg.mapper"})
public class MyBatisConfig {
    // creates the mapper bean
}
