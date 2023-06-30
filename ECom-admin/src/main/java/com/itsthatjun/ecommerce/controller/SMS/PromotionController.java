package com.itsthatjun.ecommerce.controller.SMS;

import com.itsthatjun.ecommerce.dto.SMS.OnSaleRequest;
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

    @PostMapping("/createList")
    @ApiOperation("")
    public List<Product> createList(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.createList(request);
    }

    @PostMapping("/createBrandSale")
    @ApiOperation("")
    public List<Product> createBrandSale(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.createBrandSale(request);
    }

    @PostMapping("/createCategorySale")
    @ApiOperation("")
    public List<Product> createCategorySale(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.createCategorySale(request);
    }

    @PostMapping("/updateStatus")
    @ApiOperation("")
    public OnSaleRequest updateStatus(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateStatus(request);
    }

    @PostMapping("/updateSaleDate")
    @ApiOperation("")
    public OnSaleRequest updateSaleDate(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateStatus(request);
    }

    @PostMapping("/updateSaleAmount")
    @ApiOperation("")
    public OnSaleRequest updateSaleAmount(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateSaleAmount(request);
    }

    @PostMapping("/updateSaleLimit")
    @ApiOperation("")
    public OnSaleRequest updateSaleLimit(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateSaleLimt(request);
    }

    @PostMapping("/updateSaltType")
    @ApiOperation("")
    public OnSaleRequest updateSaleType(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateSaleType(request);
    }

    @DeleteMapping("/delete/{promotionSaleId}")
    @ApiOperation("")
    public void delete(@PathVariable int promotionSaleId) {
        salesServiceimpl.delete(promotionSaleId);
    }
}
