package com.itsthatjun.ecommerce.exceptions.CMS;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArticleException extends RuntimeException{
    public ArticleException(String message) {
        super(message);
    }
}
