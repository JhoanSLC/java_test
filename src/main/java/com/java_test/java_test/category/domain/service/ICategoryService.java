package com.java_test.java_test.category.domain.service;

import java.util.List;

import com.java_test.java_test.category.dto.CategoryDto;

// This is an interface defining the contract for the Category service
public interface ICategoryService {

    // Method to create a new category, taking a CategoryDto as input and returning a CategoryDto
    CategoryDto create(CategoryDto categoryDto);

    // Method to retrieve all categories, returning a list of CategoryDto objects
    List<CategoryDto> getAll();

    // Method to delete a category by its ID
    void delete(Long categoryId);
}
