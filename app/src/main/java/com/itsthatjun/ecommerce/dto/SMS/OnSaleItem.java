package com.itsthatjun.ecommerce.dto.SMS;

import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.mbg.model.Product;
import lombok.Data;

import java.util.Date;

@Data
public class OnSaleItem {
    Product product;
    Brand brand;
    Double discountAmount;
    int numberAvailable;
    Date timeStart;
    Date timeEnd;
}
