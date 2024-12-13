package com.java_test.java_test.databaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {
    
    // This method initializes the database by checking if it exists, and creating it if not
    public static void initializeDatabase() {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:1402/postgres"; // URL of the PostgreSQL server
        String user = "postgres"; // Database username
        String password = "password"; // Database password

        try (
            // Establish connection to the PostgreSQL server
            Connection conn = DriverManager.getConnection(url, user, password);
            // Create a Statement object to execute SQL queries
            Statement stmt = conn.createStatement()
        ) {
            // SQL query to check if the 'campusjavatest' database already exists
            String checkDatabase = "SELECT 1 FROM pg_database WHERE datname = 'campusjavatest'";
            var rs = stmt.executeQuery(checkDatabase);

            // If the database does not exist, create it
            if (!rs.next()) {
                // SQL query to create the 'campusjavatest' database
                String createDatabase = "CREATE DATABASE campusjavatest";
                stmt.executeUpdate(createDatabase);
                // Output a success message
                System.out.println("Database created successfully!!");
            } else {
                // Output a message if the database already exists
                System.out.println("Database already exists");
            }
        } catch (Exception e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
}
