package com.itsthatjun.ecommerce.dto;

import lombok.Data;

@Data
public class OrderParam {

    private Long memberReceiveAddressId;
    private Long couponId;
    private Integer useIntegration;
    private Integer payType;

}
