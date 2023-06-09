package com.itsthatjun.ecommerce.controller.SMS;

import com.itsthatjun.ecommerce.dto.SMS.OnSaleItem;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flashsale")
@Api(tags = "Sales related", description = "Item on sale for a short time or set number of item for sale, or anything " +
        "like used item or clarance sale")
public class FlashSalesController {

    // TODO: add flash sale
    @PostMapping("/")
    public OnSaleItem createProductSles(OnSaleItem saleItem) {
        return saleItem;
    }
}
