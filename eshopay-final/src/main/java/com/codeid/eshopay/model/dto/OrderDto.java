package com.codeid.eshopay.model.dto;

import java.time.LocalDate;

import com.codeid.eshopay.model.entity.Location;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Integer orderId;

    private LocalDate orderDate;

    private LocalDate requiredDate;

    private LocalDate shippedDate;

    private Integer shipVia;

    private Double freight;

    private String shipName;

    private Double totalDiscount;

    private Double totalAmount;

    private String paymentType;

    private String transacNo;

    private LocalDate transacDate;

    private Location location;

    private UserResponseDto userResponseDto;

    private Integer employeeId;
}
