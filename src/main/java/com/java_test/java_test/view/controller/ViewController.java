package com.java_test.java_test.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // This annotation marks the class as a Spring MVC controller, handling web requests
public class ViewController {

    // This method handles GET requests for the /categoriesPage URL
    @GetMapping("/categoriesPage")
    public String categoriesPage() {
        // Returns the name of the view to be rendered (e.g., a Thymeleaf template named "categories.html")
        return "categories";
    }

    // This method handles GET requests for the /productsPage URL
    @GetMapping("/productsPage")
    public String productsPage() {
        // Returns the name of the view to be rendered (e.g., a Thymeleaf template named "products.html")
        return "products";
    }
}
