package com.codeid.eshopay.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {
    private String paymentType;
    private String transacNo;
    private LocalDate transacDate;
    private LocalDate requiredDate;
    private Integer shipVia;
    private String shipName;
    private Integer locationId;
}
