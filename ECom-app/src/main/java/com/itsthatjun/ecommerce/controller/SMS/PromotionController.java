package com.itsthatjun.ecommerce.controller.SMS;

import com.itsthatjun.ecommerce.dto.SMS.OnSaleItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
@Api(tags = "Sales related", description = "Item on sale for a set of time")
public class PromotionController {


    // TODO: add promotion sale
    @PostMapping("/create")
    @ApiOperation(value = "Create a product")
    public OnSaleItem createProductSles(OnSaleItem saleItem) {
        return saleItem;
    }

    @GetMapping("/all")
    @ApiOperation(value = "List all item that's on sale")
    public List<OnSaleItem> listAllOnsaleItem() {

        return null;
    }
}
