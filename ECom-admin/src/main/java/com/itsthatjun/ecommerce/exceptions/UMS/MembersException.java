package com.itsthatjun.ecommerce.exceptions.UMS;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MembersException extends RuntimeException {
    public MembersException(String message) {
        super(message);
    }
}