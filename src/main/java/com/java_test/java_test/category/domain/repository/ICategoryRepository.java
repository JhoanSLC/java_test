package com.java_test.java_test.category.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_test.java_test.category.domain.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long>{

}
