package com.codeid.eshopay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopay.model.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
    Optional<Cart> findByUserUserId(Integer userId);
}
