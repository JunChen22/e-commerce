package com.itsthatjun.ecommerce.dto.PMS;

import com.itsthatjun.ecommerce.mbg.model.*;
import lombok.Data;

import java.util.List;

@Data
public class ProductDetail {

    private Product product;
    private Brand brand;
    private List<ProductAttribute> productAttributeList;
    private List<Review> reviews;

    /* TODO:
    private List<SKU> skuList
    private List<Picture> pictures
    private List<picture> descriptionPicures
    private List<ProductAttributeCategory> productAttributeCategoryList;
    private List<ProductAttributeType> productAttributeTypesList;
    private List<Coupon> couponList;

     */
}
