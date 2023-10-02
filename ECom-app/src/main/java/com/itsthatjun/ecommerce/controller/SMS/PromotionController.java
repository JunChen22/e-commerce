package com.itsthatjun.ecommerce.controller.SMS;

import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.PromotionSale;
import com.itsthatjun.ecommerce.service.SMS.implementation.SalesServiceimpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@Api(tags = "Sales related", description = "Item on sale for a set of time")
public class PromotionController {

    private final SalesServiceimpl salesServiceimpl;

    @Autowired
    public PromotionController(SalesServiceimpl salesServiceimpl) {
        this.salesServiceimpl = salesServiceimpl;
    }

    @GetMapping("/AllPromotionSale")
    @ApiOperation("")
    public List<PromotionSale> getAllPromotionSale() {
        return salesServiceimpl.getAllPromotionalSale();
    }

    @GetMapping("/AllPromotionSaleItem")
    @ApiOperation("")
    public List<Product> getAllPromotionSaleItem() {
        return salesServiceimpl.getAllPromotionalSaleItems();
    }

    @GetMapping("/AllFlashSaleItem")
    @ApiOperation("")
    public List<Product> getAllFlashSaleItem() {
        return salesServiceimpl.getAllFlashSaleItems();
    }
}
