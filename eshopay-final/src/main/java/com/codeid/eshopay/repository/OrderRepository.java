package com.codeid.eshopay.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopay.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
    List<Order> findByUserUserId(Integer userId);
}
