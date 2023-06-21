package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.mbg.model.CartItem;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface CartItemService {

    @ApiModelProperty(value = "add an item to shopping cart")
    List<CartItem> addItem(CartItem item);

    @ApiModelProperty(value = "add all item to shopping cart")
    List<CartItem> addAllItem(List<CartItem> itemList);

    @ApiModelProperty(value = "get user's shopping cart")
    List<CartItem> getUserCart();

    @ApiModelProperty(value = "update a item quantity in shopping cart")
    List<CartItem> updateQuantity(int cartItemId, int quantity);

    @ApiModelProperty(value = "delete an item in shopping cart")
    void deleteCartItem(int cartItemId);

    @ApiModelProperty(value = "clear shopping cart")
    void clearCartItem();
}
