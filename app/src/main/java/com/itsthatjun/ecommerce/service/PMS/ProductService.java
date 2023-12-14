package com.itsthatjun.ecommerce.service.PMS;

import com.itsthatjun.ecommerce.mbg.model.Product;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

public interface ProductService {
    @ApiOperation(value = "")
    List<Product> listAllProduct();

    @ApiOperation(value = "")
    List<Product> listProduct(int pageNum, int pageSize);

    @ApiOperation(value = "")
    Product getProduct(int id);

    @ApiOperation("Generated order, increase sku lock stock")
    public void updatePurchase(Map<String, Integer> skuQuantity);

    @ApiOperation("Generated order and success payment, decrease product stock, decrease sku stock and sku lock stock")
    public void updatePurchasePayment(Map<String, Integer> skuQuantity);

    @ApiOperation("Generated order and success payment and return, increase product stock and sku stock")
    public void updateReturn(Map<String, Integer> skuQuantity);

    @ApiOperation("Generated order and failure payment, decrease sku lock stock")
    public void updateFailPayment(Map<String, Integer> skuQuantity);
}
