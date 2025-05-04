package com.codeid.eshopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopper.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
