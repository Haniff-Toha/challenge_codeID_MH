package com.codeid.eshopay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeid.eshopay.model.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
    List<CartItem> findByCartCartId(Integer cartId);
    Optional<CartItem> findByCartCartIdAndProductProductId(Integer cartId,Integer productId);

}
