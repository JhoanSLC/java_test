package com.java_test.java_test.category.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Automatically generates getters, setters
@AllArgsConstructor // Creates a constructor with all fields of the class
@NoArgsConstructor // Creates a no-arguments constructor
@Entity 
public class Category {

    @Id // Indicates that this field is the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the value of this field is automatically generated (auto-incremented)
    private Long id;

    @Column(nullable = false, unique = true) // Specifies that this column cannot be null and must be unique
    @Size(min = 3, max = 50) // Defines a size constraint for this field, with a minimum of 3 characters and a maximum of 50 characters
    private String name; 

}
