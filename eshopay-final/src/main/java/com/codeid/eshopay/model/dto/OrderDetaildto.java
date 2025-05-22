package com.codeid.eshopay.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetaildto {
    private Integer orderId;

    private Integer productId;

    private ProductDto products;
}
