package com.java_test.java_test.category.mapper;

import com.java_test.java_test.category.domain.entity.Category;
import com.java_test.java_test.category.dto.CategoryDto;

public class CategoryMapper {

    public static CategoryDto toDto(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }

    public static Category toEntity(CategoryDto dto) {
        return new Category(dto.getId(), dto.getName());
    }
}
