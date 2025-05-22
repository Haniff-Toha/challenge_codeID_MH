package com.codeid.eshopay.service;

// import com.codeid.eshopay.model.dto.OrderDetaildto;
import com.codeid.eshopay.model.dto.OrderDto;
import com.codeid.eshopay.model.dto.OrderResponseDto;
import com.codeid.eshopay.model.entity.Order;

public interface OrderService extends BaseCrudService<Order,Integer>{
    OrderDto createOrder(Integer userId, OrderResponseDto orderResponseDto);
}
