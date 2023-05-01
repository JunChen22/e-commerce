package com.itsthatjun.ecommerce.elasticsearch.document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EsProductAttribute {
    private Long id;
    private Long productAttributeId;
    private String name;
    private String type;
    private String value;
}
