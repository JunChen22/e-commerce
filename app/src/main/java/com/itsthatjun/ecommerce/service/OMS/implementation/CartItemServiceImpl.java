package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.CartItemMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ProductSkuMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ShoppingCartMapper;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.CartItemService;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final ProductSkuMapper skuMapper;

    private final ShoppingCartMapper shoppingCartMapper;

    private final CartItemMapper cartItemMapper;


    @Autowired
    public CartItemServiceImpl(ProductSkuMapper skuMapper, ShoppingCartMapper shoppingCartMapper, CartItemMapper cartItemMapper, MemberServiceImpl memberService) {
        this.skuMapper = skuMapper;
        this.shoppingCartMapper = shoppingCartMapper;
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public List<CartItem> getUserCart(int userId) {
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andMemberIdEqualTo(userId);
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByExample(shoppingCartExample);

        ShoppingCart cart = shoppingCarts.get(0);
        CartItemExample example = new CartItemExample();
        example.createCriteria().andCartIdEqualTo(cart.getId());
        return cartItemMapper.selectByExample(example);
    }

    @Override
    public List<CartItem> addItem(CartItem newItem, int userId) {
        ShoppingCart currentShoppingCart  = getCurrentCart(userId);

        CartItemExample cartItemExample = new CartItemExample();
        cartItemExample.createCriteria().andCartIdEqualTo(currentShoppingCart.getId());
        List<CartItem> currentCartItems = cartItemMapper.selectByExample(cartItemExample);
        String productSkuCode = newItem.getProductSku();
        boolean existingInCart = false;

        for (CartItem item : currentCartItems) {
            if (item.getProductSku().equals(productSkuCode)) {
                int currentQuantity = item.getQuantity();
                item.setQuantity(currentQuantity + newItem.getQuantity());
                item.setModifyDate(new Date());
                cartItemMapper.updateByPrimaryKeySelective(item);
                existingInCart = true;
                break;
            }
        }

        if (!existingInCart) {
            ProductSkuExample skuExample = new ProductSkuExample();
            skuExample.createCriteria().andSkuCodeEqualTo(productSkuCode);
            List<ProductSku> skuList = skuMapper.selectByExample(skuExample);

            if (skuList.isEmpty()) throw new RuntimeException("Sku code error, does not exist: " + productSkuCode);

            ProductSku sku = skuList.get(0);

            newItem.setCartId(currentShoppingCart.getId());
            newItem.setProductId(sku.getProductId());
            newItem.setPrice(sku.getPrice());
            newItem.setProductPic(sku.getPicture());
            newItem.setCreatedAt(new Date());
            cartItemMapper.insert(newItem);
        }

        // check quantity and price
        currentCartItems = cartItemMapper.selectByExample(cartItemExample);
        return currentCartItems;
    }

    @Override
    public List<CartItem> updateQuantity(int cartItemId, int newQuantity, int userId) {
        ShoppingCart cart = getCurrentCart(userId);
        CartItem currentCartItem = cartItemMapper.selectByPrimaryKey(cartItemId);

        if (currentCartItem == null) throw new RuntimeException("cart item does not exist"); // TODO: need to change error when they are thrown it will cause a loop need someone to catch it

        currentCartItem.setQuantity(newQuantity);
        cartItemMapper.updateByPrimaryKey(currentCartItem);

        CartItemExample cartItemExample = new CartItemExample();
        cartItemExample.createCriteria().andCartIdEqualTo(cart.getId());
        List<CartItem> updatedCart = cartItemMapper.selectByExample(cartItemExample);
        return updatedCart;
    }

    @Override
    public void deleteCartItem(int cartItemId, int userId) {
        ShoppingCart cart = getCurrentCart(userId);

        CartItemExample example = new CartItemExample();
        example.createCriteria().andCartIdEqualTo(cart.getId()).andIdEqualTo(cartItemId);
        List<CartItem> cartItemList = cartItemMapper.selectByExample(example);

        if (cartItemList.isEmpty()) throw new RuntimeException("Item does not exist");

        cartItemMapper.deleteByExample(example);
    }

    @Override
    public void clearCartItem(int userId) {
        ShoppingCart cart = getCurrentCart(userId);

        CartItemExample example = new CartItemExample();
        example.createCriteria().andCartIdEqualTo(cart.getId());
        cartItemMapper.deleteByExample(example);
    }

    private ShoppingCart getCurrentCart (int userId) {
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andMemberIdEqualTo(userId);
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByExample(shoppingCartExample);
        ShoppingCart currentShoppingCart;
        // doesn't have shopping cart in database yet
        if (shoppingCarts.isEmpty()) {
            ShoppingCart newCart = new ShoppingCart();
            newCart.setMemberId(userId);
            shoppingCartMapper.insert(newCart);
            currentShoppingCart = newCart;
        } else {
            currentShoppingCart = shoppingCarts.get(0);
        }
        return currentShoppingCart;
    }
}
