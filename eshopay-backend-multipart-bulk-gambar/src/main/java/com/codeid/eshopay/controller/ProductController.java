package com.codeid.eshopay.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// import com.codeid.eshopay.model.dto.DependentBulkDto;
import com.codeid.eshopay.model.dto.ProductDto;
import com.codeid.eshopay.model.dto.ProductImagesBulkDto;
import com.codeid.eshopay.model.enumeration.EnumStatus;
import com.codeid.eshopay.model.response.ApiResponse;
import com.codeid.eshopay.service.BaseCrudService;
import com.codeid.eshopay.service.FileStorageService;
import com.codeid.eshopay.service.ProductImagesService;
import com.codeid.eshopay.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/")
public class ProductController extends BaseMultipartController<ProductDto, Integer>{
    
    private final ProductService productService;
    private final FileStorageService fileStorageService;
    private final ProductImagesService productImagesService;

    @Override
    protected BaseCrudService<ProductDto, Integer> getService() {
        return productService;    
    }
    
    @Override
    public ResponseEntity<ProductDto> create(@Valid ProductDto entity) {
        return super.create(entity);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<ProductDto> getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<ProductDto> update(Integer id, @Valid ProductDto entity) {
        return super.update(id, entity);
    }

    @Override
    public ResponseEntity<?> createMultipart(ProductDto dto, MultipartFile file, String description) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload product photo");
        }

        try {
            String fileName = fileStorageService.storeFileWithRandomName(file);
            
            dto.setPhoto(fileName);
            var productDto= productService.save(dto);    

            // ApiResponse<ProductDto> response = new ApiResponse<ProductDto>(EnumStatus.Succeed.toString(), "Product created", productDto);

            var response = ApiResponse.builder()
                .status(EnumStatus.Succeed.toString())
                .message("Product created")
                .data(productDto)
                .build();

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }    
    }

    @Override
    public ResponseEntity<?> viewImage(String fileName) {
        try {
            Resource resource = fileStorageService.loadFile(fileName);
            
            // Cek jika file adalah image
            String contentType = determineContentType(fileName);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, 
                           "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }    
    }

    @Override
    public ResponseEntity<?> updateMultipart(Integer id, ProductDto dto, MultipartFile file, String description) {
        throw new UnsupportedOperationException("Unimplemented method 'updateMultipart'");
    }

    @GetMapping("{id}/productImages")
    public ResponseEntity<?> getProductPhotos(@PathVariable Integer id){
        var productPhotosDto = this.productImagesService.findProductPhotosByProductId(id);

        var response = ApiResponse.builder()
                        .status(EnumStatus.Succeed.toString())
                        .message("getProductPhotos()")
                        .data(productPhotosDto)
                        .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("{id}/uploadMultipleImages")
    public ResponseEntity<?> createBulkImages(@PathVariable Integer id,@RequestPart("files") MultipartFile[] files){
        
        if (files == null || files.length == 0) {
            return ResponseEntity.badRequest().body("No files uploaded");
        }
        try {
            var result = productImagesService.bulkInsert(id, files);

            var response = ApiResponse.builder()
                    .status(EnumStatus.Succeed.toString())
                    .message("Successfully uploaded multiple images")
                    .data(result)
                    .build();

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Failed to upload multiple images", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }

    }
    
}
