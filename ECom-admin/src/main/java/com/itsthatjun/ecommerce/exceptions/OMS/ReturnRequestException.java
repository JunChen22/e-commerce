package com.itsthatjun.ecommerce.exceptions.OMS;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReturnRequestException extends RuntimeException{
    public ReturnRequestException(String message) {
        super(message);
    }
}
