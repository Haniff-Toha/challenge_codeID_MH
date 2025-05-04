package com.codeid.eshopper.service;

import java.util.List;
import java.util.Optional;

import com.codeid.eshopper.entities.Product;


public interface ProductService {
    List<Product> findAllProducts();

    Product addProduct(Product product);

    Optional<Product> findProductById(Integer productId);

    void deleteProductById(Integer productId);
}
