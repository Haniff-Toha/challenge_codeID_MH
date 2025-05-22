package com.codeid.eshopay.service;

import java.util.List;

import com.codeid.eshopay.model.dto.CartDto;
import com.codeid.eshopay.model.dto.CartItemDto;

public interface CartService extends BaseCrudService<CartDto, Integer>{
    // CartDto getCartByUserId(Integer userId);
    // CartDto createCartForUser(Integer userId);

    // void addItemToCart(Integer cartId, Integer productId, Integer quantity);
    // List<CartItemDto> getItemsByCartId(Integer cartId);
    // void updateItemQuantity(Integer cartId, Integer productId, Integer newQuantity);
    // void removeItem(Integer cartId, Integer productId);
    CartDto addItem(Integer userId, CartItemDto cartItemDto);
    CartDto deleteItem(Integer userId, Integer productId);
}
