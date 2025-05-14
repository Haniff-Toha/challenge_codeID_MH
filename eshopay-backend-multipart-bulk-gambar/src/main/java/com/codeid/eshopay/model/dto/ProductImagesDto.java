package com.codeid.eshopay.model.dto;

// import com.codeid.eshopay.model.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImagesDto {
    
    private Integer prodImgId;

    private String fileName;
    
    private float fileSize;

    private String fileType;

    private String fileUri;

    private Integer productId;
}
