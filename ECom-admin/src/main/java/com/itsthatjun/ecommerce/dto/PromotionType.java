package com.itsthatjun.ecommerce.dto;

import lombok.Getter;

@Getter
public enum PromotionType {
    DISCOUNT_FOR_ALL(0),
    BRAND_DISCOUNT(1),
    CATEGORY_DISCOUNT(2),
    SPECIFIC_DISCOUNT(3);

    private final int value;

    PromotionType(int value) {
        this.value = value;
    }
}