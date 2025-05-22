package com.codeid.eshopay.service.implementation;

import com.codeid.eshopay.model.dto.CartItemDto;
import com.codeid.eshopay.model.entity.Cart;
import com.codeid.eshopay.model.entity.CartItem;
import com.codeid.eshopay.model.entity.Product;

public class CartItemServiceImpl {
    
    public static CartItemDto mapToDto(CartItem cartItem){
        return CartItemDto.builder()
                    .cartId(cartItem.getId().getCartId())
                    .productId(cartItem.getId().getProductId())
                    .products(ProductServiceImpl.mapToDto(cartItem.getProduct()))
                    .quantity(cartItem.getQuantity())
                    .discount(cartItem.getDiscount())
                    .unitPrice(cartItem.getUnitPrice())
                    .discount(cartItem.getDiscount())
                    .build();
    }

    public static CartItem mapToEntity(CartItemDto cartItemDto){
        return CartItem.builder()
                    .cart(Cart.builder().cartId(cartItemDto.getCartId()).build())
                    .product(Product.builder().productId(cartItemDto.getProductId()).build())
                    .quantity(cartItemDto.getQuantity())
                    .unitPrice(cartItemDto.getUnitPrice())
                    .discount(cartItemDto.getDiscount())
                    .build();
    }
}
