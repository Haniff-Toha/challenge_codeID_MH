package com.codeid.eshopay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeid.eshopay.model.dto.OrderDto;
import com.codeid.eshopay.model.dto.OrderResponseDto;
import com.codeid.eshopay.model.response.ApiResponse;
import com.codeid.eshopay.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/")
public class OrderController {
    private final OrderService orderService;


    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        var response = ApiResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("CartController :: getAll()")
                .data(orderService.findAll().size() == 0 ? "records not found "
                        : orderService.findAll())
                .build();
        return ResponseEntity.ok(response);
    }

    // POST /api/orders/user/{userId}
    @PostMapping("/user/{userId}")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId, @RequestBody @Valid OrderResponseDto orderCreateDto) {

        var createdOrder = orderService.createOrder(userId, orderCreateDto);

        var response = ApiResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("OrderController :: createOrder()")
                .data(createdOrder)
                .build();
        return ResponseEntity.ok(response);
    }
}
