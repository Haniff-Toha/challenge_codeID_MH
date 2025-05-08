package com.codeid.eshopay.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    
    private Integer categoryId;

    @Size(max = 15, message = "Maximum length of category name is 15")
    private String categoryName;

    private String description;

    private byte[] picture;
}
