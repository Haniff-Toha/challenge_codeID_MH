package com.codeid.eshopay.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeid.eshopay.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    //jpql
    @Query(value = "select p from Product p where lower(p.productName) = lower(:productName)")
    List<Product> findProductByProductName(@Param("productName") String keyword);

    @Query(value = "select p from Product p where p.category.categoryName=:categoryName")
    List<Product> findProductByCategory(@Param("categoryName") String keyword);

    //query method
    Page<Product> findByProductNameIgnoreCase(String keyword, Pageable pageable);

    Page<Product> findByCategoryCategoryNameIgnoreCase(String keyword, Pageable pageable);
    
}
