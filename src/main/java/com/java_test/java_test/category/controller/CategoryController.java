package com.java_test.java_test.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java_test.java_test.category.domain.service.ICategoryService;
import com.java_test.java_test.category.dto.CategoryDto;

import java.util.List;

// This annotation indicates that this class is a REST controller
@RestController
// This annotation defines the base URL for all API endpoints in this controller
@RequestMapping("/api/categories")
public class CategoryController {

    // This injects the ICategoryService instance to handle the business logic
    @Autowired
    private ICategoryService categoryService;

    // This method handles GET requests to fetch all categories
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        // Fetch all categories from the service layer
        List<CategoryDto> categories = categoryService.getAll();
        // Return the list of categories with a 200 OK status
        return ResponseEntity.ok(categories);
    }

    // This method handles POST requests to create a new category
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        // Create a new category using the service layer
        CategoryDto createdCategory = categoryService.create(categoryDto);
        // Return the created category with a 201 Created status
        return ResponseEntity.status(201).body(createdCategory);
    }

    // This method handles DELETE requests to delete a category by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        // Delete the category using the service layer
        categoryService.delete(id);
        // Return a success message with a 200 OK status
        return ResponseEntity.ok("Category deleted successfully");
    }
}
