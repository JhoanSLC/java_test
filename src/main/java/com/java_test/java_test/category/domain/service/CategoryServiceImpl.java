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

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);
        categoryRepository.save(category);
        return CategoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Category not found");
        }
        categoryRepository.deleteById(categoryId);
    }
}
