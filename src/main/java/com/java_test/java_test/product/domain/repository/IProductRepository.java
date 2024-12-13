package com.java_test.java_test.product.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_test.java_test.product.domain.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    
}
