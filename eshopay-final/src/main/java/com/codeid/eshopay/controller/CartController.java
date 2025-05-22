package com.codeid.eshopay.controller;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeid.eshopay.exception.InvalidInputException;
import com.codeid.eshopay.model.dto.CartDto;
import com.codeid.eshopay.model.dto.CartItemDto;
import com.codeid.eshopay.model.response.ApiResponse;
import com.codeid.eshopay.service.CartService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/carts/")
public class CartController {
    private final CartService cartService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        var response = ApiResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("CartController :: getAll()")
                .data(cartService.findAll().size() == 0 ? "records not found "
                        : cartService.findAll())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            log.error("Invalid cart ID: {}", id);
            throw new InternalException("cart ID must be a positive number");
        }
        var response = ApiResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("CartController :: getById()")
                .data(cartService.findById(id))
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> saveEntity(@RequestBody CartDto cartDto) {
        validateCartDto(cartDto);
        var entitySaved = this.cartService.save(cartDto);
        var response = ApiResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("CartController :: saveEntity()")
                .data(entitySaved)
                .build();
        return ResponseEntity.ok(response);
    }

    private void validateCartDto(CartDto cartDto) {
        if (cartDto.getCartId() == null) {
            throw new InvalidInputException("Project name cannot be empty");
        }
        if (cartDto.getUserId() == null) {
            throw new InvalidInputException("Client name cannot be empty");
        }

    }

    @PostMapping("{userId}")
    public ResponseEntity<?> addItem(@PathVariable Integer userId, @RequestBody CartItemDto cartItemDto) {
        var entitySaved = this.cartService.addItem(userId, cartItemDto);

        var response = ApiResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("CartController :: addItem()")
                .data(entitySaved)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}/items/{productId}")
    public ResponseEntity<?> deleteItem(
            @PathVariable Integer userId,
            @PathVariable Integer productId) {

        CartDto updatedCart = this.cartService.deleteItem(userId, productId);

        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("Item deleted successfully")
                .data(updatedCart)
                .build();

        return ResponseEntity.ok(response);
    }
}
