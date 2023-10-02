package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.dto.SMS.OnSaleRequest;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.PromotionSale;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

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

    @ApiOperation(value = "create sale on list of items")
    PromotionSale createListSale(OnSaleRequest request, String operator);

    /* TODO: create sepearate sale creation, currently is passed in after they are searched.
    @ApiOperation(value = "create sales based on brand name")
    PromotionSale createBrandSale(OnSaleRequest request, String operator);

    @ApiOperation(value = "create sales based on product category")
    PromotionSale createCategorySale(OnSaleRequest request, String operator);
     */

    @ApiOperation(value = "Update price, revert back to original after sale limit is reached")
    void updateSaleLimitPrice();

    @ApiOperation(value = "Update price, revert back to original price after time limit")
    void updateSaleTimeFramePrice();

    @ApiOperation(value = "Update info like name, sale type and time, non-price affecting")
    PromotionSale updateSaleInfo(OnSaleRequest updateSaleRequest, String operator);

    @ApiOperation(value = "Update sale discount percent or fixed amount. price affecting")
    PromotionSale updateSalePrice(OnSaleRequest updateSaleRequest, String operator);

    @ApiOperation(value = "Update sale to be online or off line, price affecting")
    PromotionSale updateSaleStatus(OnSaleRequest updateSaleRequest, String operator);

    @ApiOperation(value = "delete")
    void delete(int promotionSaleId, String operator);
}
