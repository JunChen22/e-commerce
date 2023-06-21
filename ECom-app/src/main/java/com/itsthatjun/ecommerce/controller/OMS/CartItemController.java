package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.mbg.model.CartItem;
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
    public List<CartItem> add(@RequestBody CartItem cartItem) {
        return cartItemService.addItem(cartItem);
    }

    @ApiOperation("add all item to shopping cart")
    @PostMapping(value = "/add/all")
    public List<CartItem> addAll(@RequestBody List<CartItem> cartItem) {
        return cartItemService.addAllItem(cartItem);
    }

    @ApiOperation("list current user's shopping cart")
    @GetMapping(value = "/list")
    public List<CartItem> list() {
        return cartItemService.getUserCart();
    }

    @ApiOperation("update shopping cart item quantity")
    @PostMapping(value = "/update/quantity")
    public List<CartItem> updateQuantity(@RequestParam int cartItemId, @RequestParam int quantity) {
        return cartItemService.updateQuantity(cartItemId, quantity);
    }

    @ApiOperation("remove item from shopping cart")
    @DeleteMapping(value = "/delete/{cartItemId}")
    public void delete(@PathVariable int cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
    }

    @ApiOperation("clear user shopping cart")
    @DeleteMapping(value = "/clear")
    public void clear() {
        cartItemService.clearCartItem();
    }
}
