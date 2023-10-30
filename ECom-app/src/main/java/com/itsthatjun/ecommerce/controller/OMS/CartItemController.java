package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.mbg.model.CartItem;
import com.itsthatjun.ecommerce.service.Messaging.CartMessageService;
import com.itsthatjun.ecommerce.service.OMS.implementation.CartItemServiceImpl;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "shopping cart controller", description = "shopping cart and related api")
@RequestMapping("/cart")
public class CartItemController {

    private final CartItemServiceImpl cartService;

    private final MemberServiceImpl memberService;

    private final CartMessageService messageService;

    @Autowired
    public CartItemController(CartItemServiceImpl cartService, MemberServiceImpl memberService, CartMessageService messageService) {
        this.cartService = cartService;
        this.memberService = memberService;
        this.messageService = messageService;
    }

    @ApiOperation("list current user's shopping cart")
    @GetMapping(value = "/list")
    public List<CartItem> list() {
        int userId = memberService.getCurrentUser().getId();
        return cartService.getUserCart(userId);
    }

    @ApiOperation("add item to shopping cart")
    @PostMapping(value = "/add")
    public CartItem add(@RequestBody CartItem cartItem) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendCartAddMessage(cartItem, userId);
        return cartItem;
    }

    @ApiOperation("update shopping cart item quantity")
    @PostMapping(value = "/update/quantity")
    public CartItem updateQuantity(@RequestBody CartItem cartItem) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendCartUpdateMessage(cartItem, userId);
        return cartItem;
    }

    @ApiOperation("remove item from shopping cart")
    @DeleteMapping(value = "/delete/{cartItemId}")
    public void delete(@PathVariable int cartItemId) {
        int userId = memberService.getCurrentUser().getId();
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartItemId);
        messageService.sendCartDeleteMessage(cartItem, userId);
    }

    @ApiOperation("clear user shopping cart")
    @DeleteMapping(value = "/clear")
    public void clear() {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendCartClearMessage(userId);
    }
}
