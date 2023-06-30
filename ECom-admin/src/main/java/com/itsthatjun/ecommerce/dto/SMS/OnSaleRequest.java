package com.itsthatjun.ecommerce.dto.SMS;

import com.itsthatjun.ecommerce.mbg.model.Product;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class OnSaleRequest {

    List<Product> product;
    Map<Integer, List<String>> productIdToSkuCode;

    String name;
    int promotionType;  //-- discount on 0-> all, 1 -> specific brand,  2-> specific category , 3-> specific item(s)
    int discountType;   // 0 -> by amount , 1->  by percent off amount numeric,
    Double amount;

    int productCategoryId;
    int brandId;

    int numberAvailable;     // TODO: limit sale amount(quantity)
    Date startTime;
    Date endTime;
    int status;

}
