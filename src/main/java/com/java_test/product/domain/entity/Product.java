package com.java_test.product.domain.entity;

import com.java_test.category.domain.entity.Category;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Automatically generates getters, setters
@NoArgsConstructor // Creates a no-arguments constructor
@AllArgsConstructor // Creates a constructor with all fields of the class
@Entity
public class Product {

    @Id // Specifies that this field is the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the value of this field is auto-generated (auto-incremented)
    private Long id;

    @Column(nullable = false) // Specifies that this column cannot be null
    @Size(min = 3, max = 100) // Enforces that the name must be between 3 and 50 characters long
    private String name;

    @Column(length = 255) // Specifies that the maximum length for this column is 255 characters
    private String description; 

    @Column(nullable = false) // Specifies that this column cannot be null
    @Positive // Enforces that the price must be a positive value
    private Double price; // Price of the product, must be greater than 0

    @ManyToOne // Defines a many-to-one relationship with the Category entity
    @JoinColumn(name = "categoria_id", nullable = false) // Specifies the foreign key column name and ensures it cannot be null
    private Category category; // The category to which the product belongs
}
