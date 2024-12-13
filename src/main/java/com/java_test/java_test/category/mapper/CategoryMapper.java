package com.java_test.java_test.category.mapper;

import com.java_test.java_test.category.domain.entity.Category;
import com.java_test.java_test.category.dto.CategoryDto;

// This class contains methods to map between Category and CategoryDto objects
public class CategoryMapper {

    // This method converts a Category entity to a CategoryDto
    public static CategoryDto toDto(Category category) {
        // Return a new CategoryDto with the values from the Category entity
        return new CategoryDto(category.getId(), category.getName());
    }

    // This method converts a CategoryDto to a Category entity
    public static Category toEntity(CategoryDto dto) {
        // Return a new Category entity with the values from the CategoryDto
        return new Category(dto.getId(), dto.getName());
    }
}
