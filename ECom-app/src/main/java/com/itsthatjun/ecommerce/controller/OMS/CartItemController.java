package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.service.OMS.implementation.CartItemServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "shopping cart controller", description = "shopping cart and related api")
@RequestMapping("/cart")
public class CartItemController {

    private final CartItemServiceImpl cartItemService;

    @Autowired
    public CartItemController(CartItemServiceImpl cartItemService) {
        this.cartItemService = cartItemService;
    }

    @ApiOperation("add item to shopping cart")
    @PostMapping(value = "/add")
    public String add(@RequestBody String cartItem) {
        return "";
    }

    @ApiOperation("list current user's shopping cart")
    @GetMapping(value = "/list")
    public List<String> list() {
        return new ArrayList<>();
    }

    @ApiOperation("update shopping cart item quantity")
    @PostMapping(value = "/update/quantity")
    public String updateQuantity(@RequestParam Long id, @RequestParam Integer quantity) {
       return "";
    }

    @ApiOperation("remove item from shopping cart")
    @PostMapping(value = "/delete")
    public String delete(@RequestParam("ids") List<Long> ids) {
        return "";
    }

    @ApiOperation("clear user shopping cart")
    @PostMapping(value = "/clear")
    public String clear() {
        return "";
    }

}
