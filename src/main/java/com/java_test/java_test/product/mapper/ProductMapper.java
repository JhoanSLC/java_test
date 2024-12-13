package com.java_test.java_test.product.mapper;

import com.java_test.java_test.category.domain.entity.Category;
import com.java_test.java_test.product.domain.entity.Product;
import com.java_test.java_test.product.dto.ProductDto;

public class ProductMapper {

    // Converts a Product entity to a ProductDto
    public static ProductDto toDto(Product product) {
        return new ProductDto(
            product.getId(), // Map product's ID to the DTO
            product.getName(), // Map product's name to the DTO
            product.getDescription(), // Map product's description to the DTO
            product.getPrice(), // Map product's price to the DTO
            product.getCategory().getId() // Map the associated category's ID to the DTO
        );
    }

    // Converts a ProductDto to a Product entity, associating it with a Category
    public static Product toEntity(ProductDto dto, Category category) {
        return new Product(
            dto.getId(), // Map the DTO's ID to the entity
            dto.getName(), // Map the DTO's name to the entity
            dto.getDescription(), // Map the DTO's description to the entity
            dto.getPrice(), // Map the DTO's price to the entity
            category // Associate the product with the given category
        );
    }
}
