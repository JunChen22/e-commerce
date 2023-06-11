package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.dto.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnApply;
import com.itsthatjun.ecommerce.service.OMS.implementation.ReturnOrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order/return")
@Api(tags = "return related", description = "apply return and related api")
public class OrderReturnController {

    private final ReturnOrderServiceImpl returnOrderService;

    @Autowired
    public OrderReturnController(ReturnOrderServiceImpl returnOrderService) {
        this.returnOrderService = returnOrderService;
    }

    @PostMapping("/apply")
    @ApiOperation(value = "")
    public Map<String, Object> applyForReturn(){
       return null;
    }

    @GetMapping("/status")
    @ApiOperation(value = "")
    public Map<String, Object> generateOrder(@RequestBody OrderParam orderParam){
        return null;
    }
}
