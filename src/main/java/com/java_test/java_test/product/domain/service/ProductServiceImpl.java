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

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public ProductDto create(ProductDto productDto) {
        // Find the category based on categoryId in DTO
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        // Map DTO to entity and save it
        Product product = ProductMapper.toEntity(productDto, category);
        productRepository.save(product);

        // Return DTO after saving
        return ProductMapper.toDto(product);
    }

    @Override
    public ProductDto getById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ProductMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto update(Long productId, ProductDto productDto) {
        // Find the existing product
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Find the category
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        // Update product fields
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);

        // Save and return updated product
        productRepository.save(product);
        return ProductMapper.toDto(product);
    }

    @Override
    public void delete(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Product not found");
        }
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> getByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }
}
