package com.java_test.java_test.category.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_test.java_test.category.domain.entity.Category;
import com.java_test.java_test.category.domain.repository.ICategoryRepository;
import com.java_test.java_test.category.dto.CategoryDto;
import com.java_test.java_test.category.mapper.CategoryMapper;
import com.java_test.java_test.customExceptions.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

// This annotation marks the class as a Spring service component, which holds business logic
@Service
public class CategoryServiceImpl implements ICategoryService {

    // This injects the ICategoryRepository instance to interact with the database
    @Autowired
    private ICategoryRepository categoryRepository;

    // This method creates a new category from the provided CategoryDto and saves it to the database
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        // Convert the CategoryDto to a Category entity using the CategoryMapper
        Category category = CategoryMapper.toEntity(categoryDto);
        // Save the category entity to the repository (database)
        categoryRepository.save(category);
        // Convert the saved Category entity back to a CategoryDto and return it
        return CategoryMapper.toDto(category);
    }

    // This method retrieves all categories from the database and returns them as a list of CategoryDto objects
    @Override
    public List<CategoryDto> getAll() {
        // Fetch all categories from the repository, convert them to DTOs, and return as a list
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDto)  // Convert each Category entity to a CategoryDto
                .collect(Collectors.toList()); // Collect the result into a list
    }

    // This method deletes a category by its ID if it exists
    @Override
    public void delete(Long categoryId) {
        // Check if the category with the given ID exists in the repository
        if (!categoryRepository.existsById(categoryId)) {
            // If not, throw a custom exception indicating the category was not found
            throw new ResourceNotFoundException("Category not found");
        }
        // If the category exists, delete it from the repository
        categoryRepository.deleteById(categoryId);
    }
}
