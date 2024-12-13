package com.java_test.java_test.category.domain.service;

import java.util.List;

import com.java_test.java_test.category.dto.CategoryDto;

public interface ICategoryService {
    CategoryDto create(CategoryDto categoryDto);
    List<CategoryDto> getAll();
    void delete(Long categoryId);
}
