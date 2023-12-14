package com.itsthatjun.ecommerce.dto;


import lombok.Getter;

@Getter
public enum DiscountType {
    BY_AMOUNT(0),
    BY_PERCENT(1);

    private final int value;

    DiscountType(int value) {
        this.value = value;
    }
}