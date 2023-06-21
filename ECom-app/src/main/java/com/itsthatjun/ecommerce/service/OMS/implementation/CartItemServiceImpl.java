package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.CartItemMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ShoppingCartMapper;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.CartItemService;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final ShoppingCartMapper shoppingCartMapper;

    private final CartItemMapper cartItemMapper;

    private final MemberServiceImpl memberService;

    @Autowired
    public CartItemServiceImpl(ShoppingCartMapper shoppingCartMapper, CartItemMapper cartItemMapper, MemberServiceImpl memberService) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.cartItemMapper = cartItemMapper;
        this.memberService = memberService;
    }

    @Override
    public List<CartItem> addItem(CartItem item) {
        Member currUser = memberService.getCurrentUser();

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andMemberIdEqualTo(currUser.getId());
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByExample(shoppingCartExample);

        // doesn't have shopping cart in database yet
        if (shoppingCarts == null) {
            ShoppingCart newCart = new ShoppingCart();
            newCart.setMemberId(currUser.getId());
            shoppingCartMapper.insert(newCart);
        }

        ShoppingCart currShopingCart = shoppingCartMapper.selectByExample(shoppingCartExample).get(0);

        // TODO: if exist then increase quantity but sku might be different

        item.setCartId(currShopingCart.getId());
        cartItemMapper.insert(item);

        CartItemExample cartItemExample = new CartItemExample();
        cartItemExample.createCriteria().andCartIdEqualTo(currShopingCart.getId());
        List<CartItem> itemList = cartItemMapper.selectByExample(cartItemExample);

        return itemList;
    }

    @Override
    public List<CartItem> addAllItem(List<CartItem> itemList) {
        for (CartItem item : itemList) {
            addItem(item);
        }
        return itemList;
    }

    @Override
    public List<CartItem> getUserCart() {
        Member currUser = memberService.getCurrentUser();

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andMemberIdEqualTo(currUser.getId());
        ShoppingCart cart = shoppingCartMapper.selectByExample(shoppingCartExample).size() > 0 ?
                shoppingCartMapper.selectByExample(shoppingCartExample).get(0) : null;
        if (cart == null) throw new RuntimeException("error getting user shopping cart");

        CartItemExample example = new CartItemExample();
        example.createCriteria().andCartIdEqualTo(cart.getId());
        List<CartItem> shoppingCartItemList = cartItemMapper.selectByExample(example);

        return shoppingCartItemList;
    }

    @Override
    public List<CartItem> updateQuantity(int cartItemId, int quantity) {
        Member currUser = memberService.getCurrentUser();

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andMemberIdEqualTo(currUser.getId());
        ShoppingCart cart = shoppingCartMapper.selectByExample(shoppingCartExample).get(0);

        CartItemExample example = new CartItemExample();
        example.createCriteria().andCartIdEqualTo(cart.getId()).andIdEqualTo(cartItemId);
        CartItem updated = cartItemMapper.selectByPrimaryKey(cartItemId);
        updated.setQuantity(quantity);
        cartItemMapper.updateByExampleSelective(updated, example);

        example.clear();
        example.createCriteria().andCartIdEqualTo(cart.getId());
        return cartItemMapper.selectByExample(example);
    }

    @Override
    public void deleteCartItem(int cartItemId) {
        Member currUser = memberService.getCurrentUser();

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andMemberIdEqualTo(currUser.getId());
        ShoppingCart cart = shoppingCartMapper.selectByExample(shoppingCartExample).get(0);

        CartItemExample example = new CartItemExample();
        example.createCriteria().andCartIdEqualTo(cart.getId()).andIdEqualTo(cartItemId);
        cartItemMapper.deleteByExample(example);
    }

    @Override
    public void clearCartItem() {
        Member currUser = memberService.getCurrentUser();

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andMemberIdEqualTo(currUser.getId());
        ShoppingCart cart = shoppingCartMapper.selectByExample(shoppingCartExample).get(0);

        CartItemExample example = new CartItemExample();
        example.createCriteria().andCartIdEqualTo(cart.getId());
        cartItemMapper.deleteByExample(example);
    }
}
