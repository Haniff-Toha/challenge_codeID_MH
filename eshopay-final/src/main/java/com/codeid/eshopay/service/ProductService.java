package com.codeid.eshopay.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.codeid.eshopay.model.dto.ProductDto;

public interface ProductService extends BaseCrudService<ProductDto, Integer>{
    
    List<ProductDto> findAll(Pageable pageable);
    List<ProductDto> findAll(String search, Pageable pageable);
    List<ProductDto> findAllWithCategory(String search, Pageable pageable);
    List<ProductDto> findProductByProductName(String search);
}
