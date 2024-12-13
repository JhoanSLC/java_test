package com.java_test.java_test.product.mapper;

import com.java_test.java_test.category.domain.entity.Category;
import com.java_test.java_test.product.domain.entity.Product;
import com.java_test.java_test.product.dto.ProductDto;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory().getId()
        );
    }

    public static Product toEntity(ProductDto dto, Category category) {
        return new Product(
            dto.getId(),
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            category
        );
    }
}
