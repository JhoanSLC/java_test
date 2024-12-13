package com.java_test.java_test.product.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    
    @NotEmpty(message = "The productDto's name cannot be empty")
    private String name;

    @NotEmpty(message = "The productDto's description cannot be empty")
    private String description;

    @NotNull(message = "The productDto's price cannot be null")
    private Double price;

    @NotNull(message = "The productDto's categoryId cannot be null")
    private Long categoryId;

}
