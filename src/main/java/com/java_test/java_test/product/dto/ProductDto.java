package com.java_test.java_test.product.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// The @Data annotation generates getters, setters, equals, hashCode, and toString methods
@Data
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields as arguments
public class ProductDto {

    private Long id; // Unique identifier for the product
    
    // Ensures that the product name cannot be empty
    @NotEmpty(message = "The productDto's name cannot be empty")
    private String name;

    // Ensures that the product description cannot be empty
    @NotEmpty(message = "The productDto's description cannot be empty")
    private String description;

    // Ensures that the product price cannot be null
    @NotNull(message = "The productDto's price cannot be null")
    private Double price;

    // Ensures that the category ID cannot be null
    @NotNull(message = "The productDto's categoryId cannot be null")
    private Long categoryId;
}
