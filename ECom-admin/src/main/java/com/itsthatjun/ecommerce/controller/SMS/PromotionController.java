package com.itsthatjun.ecommerce.controller.SMS;

import com.itsthatjun.ecommerce.dto.SMS.OnSaleRequest;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.PromotionSale;
import com.itsthatjun.ecommerce.service.SMS.implementation.SalesServiceimpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public PromotionSale createList(@RequestBody OnSaleRequest request, HttpSession session) {
        String operator = session.getAttribute("operator").toString();
        return salesServiceimpl.createListSale(request, operator);
    }

    /*
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
     */

    @PostMapping("/updateSaleDate")
    @ApiOperation("")
    public PromotionSale updateSaleInfo(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateSaleInfo(request, "admin");
    }

    @PostMapping("/updateSaleAmount")
    @ApiOperation("")
    public PromotionSale updateSalePrice(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateSalePrice(request, "admin");
    }

    @PostMapping("/updateStatus")
    @ApiOperation("")
    public PromotionSale updateSaleStatus(@RequestBody OnSaleRequest request) {
        return salesServiceimpl.updateSaleStatus(request, "admin");
    }

    @DeleteMapping("/delete/{promotionSaleId}")
    @ApiOperation("")
    public void delete(@PathVariable int promotionSaleId) {
        salesServiceimpl.delete(promotionSaleId, "admin");
    }
}
