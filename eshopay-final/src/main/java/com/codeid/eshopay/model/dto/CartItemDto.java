package com.codeid.eshopay.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDto {

    private Integer cartId;

    private Integer productId;

    private Integer quantity;

    private Double unitPrice;

    private Double discount;

    private ProductDto products;
}
