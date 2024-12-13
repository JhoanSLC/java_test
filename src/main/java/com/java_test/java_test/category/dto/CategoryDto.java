package com.java_test.java_test.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This annotation generates getters, setters, equals, hashCode, and toString methods automatically
@Data
// This annotation generates a constructor with all arguments
@AllArgsConstructor
// This annotation generates a no-argument constructor
@NoArgsConstructor
public class CategoryDto {

    // This field holds the unique identifier for the category
    private Long id;

    // This field represents the name of the category, and it cannot be null
    @NotNull
    private String name;
}
