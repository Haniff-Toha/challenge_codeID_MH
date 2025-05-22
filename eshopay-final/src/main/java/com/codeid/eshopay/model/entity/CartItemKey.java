package com.codeid.eshopay.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemKey implements Serializable{
    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "product_id")
    private Integer productId;
}
