package com.java_test.java_test.product.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java_test.java_test.product.domain.service.IProductService;
import com.java_test.java_test.product.dto.ProductDto;

import java.util.List;

// This annotation marks the class as a REST controller
@RestController
// This annotation defines the base URL for all API endpoints in this controller
@RequestMapping("/api/products")
public class ProductController {

    // This injects the IProductService instance to handle the business logic
    @Autowired
    private IProductService productService;

    // This method handles GET requests to fetch all products
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        // Fetch all products from the service layer
        List<ProductDto> products = productService.getAll();
        // Return the list of products with a 200 OK status
        return ResponseEntity.ok(products);
    }

    // This method handles GET requests to fetch a product by its ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        // Fetch the product by its ID from the service layer
        ProductDto product = productService.getById(id);
        // Return the product with a 200 OK status
        return ResponseEntity.ok(product);
    }

    // This method handles POST requests to create a new product
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        // Create a new product using the service layer
        ProductDto createdProduct = productService.create(productDto);
        // Return the created product with a 201 Created status
        return ResponseEntity.status(201).body(createdProduct);
    }

    // This method handles PUT requests to update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        // Update the product using the service layer
        ProductDto updatedProduct = productService.update(id, productDto);
        // Return the updated product with a 200 OK status
        return ResponseEntity.ok(updatedProduct);
    }

    // This method handles DELETE requests to delete a product by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        // Delete the product using the service layer
        productService.delete(id);
        // Return a success message with a 200 OK status
        return ResponseEntity.ok("Product deleted successfully");
    }

    // This method handles GET requests to fetch products by category ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable Long categoryId) {
        // Fetch the list of products for the specified category
        List<ProductDto> products = productService.getByCategory(categoryId);
        // Return the list of products with a 200 OK status
        return ResponseEntity.ok(products);
    }
}
