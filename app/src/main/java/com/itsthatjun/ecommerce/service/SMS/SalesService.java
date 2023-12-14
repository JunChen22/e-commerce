package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.PromotionSale;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public interface SalesService {

   // 0-> not on sale; 1-> is on sale; 2-> flash sale/special sales/clarance/used item
   // promotional sale and flash sale is similar
   // promotion sale is the "normal" discount. flash sale for clearance/used
   @ApiModelProperty(value = "get all promotion items on sale")  // TODO: add date interval, active status
   List<PromotionSale> getAllPromotionalSale();

    @ApiModelProperty(value = "get all promotion items on sale")
    List<Product> getAllPromotionalSaleItems();

    @ApiModelProperty(value = "get all sales items")
    List<Product> getAllFlashSaleItems();

}
