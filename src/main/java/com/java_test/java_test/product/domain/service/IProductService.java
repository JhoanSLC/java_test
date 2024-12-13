package com.java_test.java_test.product.domain.service;

import java.util.List;

import com.java_test.java_test.product.dto.ProductDto;

// This is the interface for the Product service layer, defining methods for CRUD operations
public interface IProductService {

    // This method creates a new product and returns the created ProductDto
    ProductDto create(ProductDto productDto);

    // This method retrieves a product by its ID and returns a ProductDto
    ProductDto getById(Long productId);

    // This method retrieves all products and returns a list of ProductDto
    List<ProductDto> getAll();

    // This method updates an existing product with the provided ID and returns the updated ProductDto
    ProductDto update(Long productId, ProductDto productDto);

    // This method deletes a product by its ID
    void delete(Long productId);

    // This method retrieves products belonging to a specific category and returns a list of ProductDto
    List<ProductDto> getByCategory(Long categoryId); // Get products by category
}
