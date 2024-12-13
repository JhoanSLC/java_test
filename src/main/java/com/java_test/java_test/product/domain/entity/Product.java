package com.java_test.java_test.product.domain.entity;

import com.java_test.java_test.category.domain.entity.Category;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
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
// This annotation marks the class as a JPA entity, meaning it will be mapped to a database table
@Entity
// This annotation specifies the name of the table in the database
@Table(name = "product")
public class Product {

    // This annotation marks the field as the primary key of the entity
    @Id
    // This annotation automatically generates a value for the primary key when a new entity is persisted
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This annotation specifies that the column cannot be null
    @Column(nullable = false)
    // This annotation validates that the product name is not empty
    @NotEmpty(message = "Product name cannot be empty")
    private String name;

    // This annotation marks the column for the product description, which can be nullable
    @Column
    private String description;

    // This annotation specifies that the price column cannot be null
    @Column(nullable = false)
    // This annotation validates that the price must be greater than or equal to 0.01
    @DecimalMin("0.01")
    private Double price;

    // This annotation defines a many-to-one relationship between Product and Category
    @ManyToOne
    // This annotation specifies the name of the foreign key column and ensures it cannot be null
    @JoinColumn(name = "categoryid", nullable = false)
    // This annotation validates that the category field cannot be null
    @NotNull(message = "Category cannot be null")
    private Category category;
}
