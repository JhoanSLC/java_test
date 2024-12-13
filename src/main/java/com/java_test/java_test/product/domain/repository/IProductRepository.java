package com.java_test.java_test.product.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_test.java_test.product.domain.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId); // Method to find products by category
}
