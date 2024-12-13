package com.java_test.java_test.product.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java_test.java_test.product.domain.entity.Product;
import com.java_test.java_test.product.domain.repository.IProductRepository;
import com.java_test.java_test.product.dto.ProductDto;
import com.java_test.java_test.product.mapper.ProductMapper;
import com.java_test.java_test.category.domain.entity.Category;
import com.java_test.java_test.category.domain.repository.ICategoryRepository;
import com.java_test.java_test.customExceptions.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

// This annotation marks the class as a service component in the Spring context
@Service
public class ProductServiceImpl implements IProductService {

    // Autowire the Product repository to interact with the database
    @Autowired
    private IProductRepository productRepository;

    // Autowire the Category repository to retrieve categories
    @Autowired
    private ICategoryRepository categoryRepository;

    // This method creates a new product from the given DTO and returns the created product as a DTO
    @Override
    public ProductDto create(ProductDto productDto) {
        // Find the category by ID from the product DTO
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        // Convert the ProductDto to a Product entity and associate it with the found category
        Product product = ProductMapper.toEntity(productDto, category);
        // Save the product to the database
        productRepository.save(product);

        // Return the saved product as a DTO
        return ProductMapper.toDto(product);
    }

    // This method retrieves a product by its ID and returns it as a DTO
    @Override
    public ProductDto getById(Long productId) {
        // Find the product by its ID, or throw an exception if not found
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        // Convert the product entity to a DTO and return it
        return ProductMapper.toDto(product);
    }

    // This method retrieves all products and returns them as a list of DTOs
    @Override
    public List<ProductDto> getAll() {
        // Retrieve all products, convert them to DTOs, and return as a list
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    // This method updates an existing product and returns the updated product as a DTO
    @Override
    public ProductDto update(Long productId, ProductDto productDto) {
        // Find the existing product by its ID
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Find the category by ID from the product DTO
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        // Update the product's fields with the new values from the DTO
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);

        // Save the updated product to the database
        productRepository.save(product);
        // Return the updated product as a DTO
        return ProductMapper.toDto(product);
    }

    // This method deletes a product by its ID
    @Override
    public void delete(Long productId) {
        // Check if the product exists, if not, throw an exception
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Product not found");
        }
        // Delete the product by its ID
        productRepository.deleteById(productId);
    }

    // This method retrieves all products by a specific category ID and returns them as a list of DTOs
    @Override
    public List<ProductDto> getByCategory(Long categoryId) {
        // Retrieve all products by category ID, convert them to DTOs, and return as a list
        return productRepository.findByCategoryId(categoryId).stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }
}
