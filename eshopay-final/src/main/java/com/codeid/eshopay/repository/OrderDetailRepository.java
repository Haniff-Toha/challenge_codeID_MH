package com.codeid.eshopay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopay.model.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
    Optional<OrderDetail> findByOrderOrderIdAndProductProductId(Integer orderId,Integer productId);
}
