package com.java_test.java_test.category.domain.service;

import java.util.List;

import com.java_test.java_test.category.dto.CategoryDto;

public interface ICategoryService {
    CategoryDto create(CategoryDto dto);
    CategoryDto getById(Long id);
    List<CategoryDto> getAll();
    CategoryDto update(Long id, CategoryDto updatedDto);
    void delete(Long id);
}
