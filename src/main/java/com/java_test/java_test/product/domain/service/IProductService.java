package com.java_test.java_test.product.domain.service;

import java.util.List;

import com.java_test.java_test.product.dto.ProductDto;

public interface IProductService {
    ProductDto create(ProductDto productDto);
    ProductDto getById(Long productId);
    List<ProductDto> getAll();
    ProductDto update(Long productId, ProductDto productDto);
    void delete(Long productId);
    List<ProductDto> getByCategory(Long categoryId); // Get products by category
}
