package com.itsthatjun.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EComAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EComAppApplication.class, args);
    }
}
