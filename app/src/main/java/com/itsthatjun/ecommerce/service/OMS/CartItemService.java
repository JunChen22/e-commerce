package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.CartItem;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface CartItemService {

    @ApiOperation(value = "get user's shopping cart")
    List<CartItem> getUserCart(int userId);

    @ApiOperation(value = "add an item to shopping cart")
    List<CartItem> addItem(CartItem item, int userId);

    @ApiOperation(value = "update a item quantity in shopping cart")
    List<CartItem> updateQuantity(int cartItemId, int quantity, int userId);

    @ApiOperation(value = "delete an item in shopping cart")
    void deleteCartItem(int cartItemId, int userId);

    @ApiOperation(value = "clear shopping cart")
    void clearCartItem(int userId);
}
