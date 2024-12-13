package com.java_test.java_test.category.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_test.java_test.category.domain.entity.Category;
import com.java_test.java_test.category.domain.repository.ICategoryRepository;
import com.java_test.java_test.category.dto.CategoryDto;
import com.java_test.java_test.category.mapper.CategoryMapper;
import com.java_test.java_test.customExceptions.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Override
    public CategoryDto create(CategoryDto dto) {
        Category category = new Category(dto.getId(), dto.getName());
        Category savedCategory = repository.save(category);
        return CategoryMapper.toDto(savedCategory);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));
        repository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = repository.findAll();
        return categories.stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));
        return CategoryMapper.toDto(category);
    }

    @Override
    public CategoryDto update(Long id, CategoryDto updatedDto) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));
        category.setName(updatedDto.getName());
        repository.save(category);
        return CategoryMapper.toDto(category);
    }
}
