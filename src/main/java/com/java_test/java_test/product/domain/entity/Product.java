package com.java_test.java_test.product.domain.entity;

import com.java_test.java_test.category.domain.entity.Category;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Product name cannot be empty")
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    @DecimalMin("0.01")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "categoryid", nullable = false)
    @NotNull(message = "Category cannot be null")
    private Category category;
}
