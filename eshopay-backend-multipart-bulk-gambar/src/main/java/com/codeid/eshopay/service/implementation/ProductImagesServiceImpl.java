package com.codeid.eshopay.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codeid.eshopay.model.dto.ProductImagesBulkDto;
import com.codeid.eshopay.model.dto.ProductImagesDto;
import com.codeid.eshopay.model.entity.Product;
import com.codeid.eshopay.model.entity.ProductImages;
import com.codeid.eshopay.repository.ProductImagesRepository;
import com.codeid.eshopay.service.FileStorageService;
import com.codeid.eshopay.service.ProductImagesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductImagesServiceImpl implements ProductImagesService{
    private final ProductImagesRepository productPhotosRepository;
    private final FileStorageService fileStorageService;

    public static ProductImagesDto mapToDto(ProductImages productImages){
        return ProductImagesDto.builder()
                    .prodImgId(productImages.getProdImgId())
                    .fileName(productImages.getFileName())
                    .fileSize(productImages.getFileSize())
                    .fileType(productImages.getFileType())
                    .fileUri(productImages.getFileUri())
                    .productId(productImages.getProduct().getProductId())
                    .build();
    }

    public static ProductImages mapToEntity(ProductImagesDto productImagesDto){
        return ProductImages.builder()
                    .prodImgId(productImagesDto.getProdImgId())
                    .fileName(productImagesDto.getFileName())
                    .fileSize(productImagesDto.getFileSize())
                    .fileType(productImagesDto.getFileType())
                    .fileUri(productImagesDto.getFileUri())
                    .product(Product.builder().productId(productImagesDto.getProductId()).build())
                    .build();
    }
    

    
    @Override
    public List<ProductImagesDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ProductImagesDto findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ProductImagesDto save(ProductImagesDto entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ProductImagesDto update(Integer id, ProductImagesDto entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ProductImagesDto> findProductPhotosByProductId(Integer id) {
        var result = this.productPhotosRepository.findProductImagesByProductIdJpql(id)
                        .stream()
                        .map(ProductImagesServiceImpl::mapToDto)
                        .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<ProductImagesDto> bulkInsert(Integer productId, MultipartFile[] files) {
        List<ProductImages> imagesToSave = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                String randomFileName = fileStorageService.storeFileWithRandomName(file);

                ProductImages image = ProductImages.builder()
                    .fileName(randomFileName)
                    .fileSize(file.getSize())
                    .fileType(file.getContentType())
                    .fileUri("http://localhost:8088/product/view/" + randomFileName) // or wherever it’s served
                    .product(Product.builder().productId(productId).build())
                    .build();

                imagesToSave.add(image);
            } catch (Exception e) {
                log.error("Error while storing file: {}", file.getOriginalFilename(), e);
                throw new RuntimeException("Failed to upload image: " + file.getOriginalFilename());
            }
        }

        var saved = productPhotosRepository.saveAll(imagesToSave);
        return saved.stream().map(ProductImagesServiceImpl::mapToDto).collect(Collectors.toList());
    }

    
}
