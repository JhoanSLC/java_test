package com.java_test.java_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java_test.java_test.databaseConfig.DatabaseInitializer;

@SpringBootApplication
public class JavaTestApplication {

	public static void main(String[] args) {
		DatabaseInitializer.initializeDatabase();
		SpringApplication.run(JavaTestApplication.class, args);
	}

}
