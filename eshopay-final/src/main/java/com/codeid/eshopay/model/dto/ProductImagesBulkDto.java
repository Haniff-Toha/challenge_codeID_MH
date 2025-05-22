package com.codeid.eshopay.model.dto;

import java.util.List;

// import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImagesBulkDto {
    private Integer productId;
    private List<ProductImagesDto> productImages;

}
