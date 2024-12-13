package com.java_test.java_test.databaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        String url = "jdbc:postgresql://localhost:1402/postgres";
        String user = "postgres";
        String password = "1048065293=)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {

            String checkDatabase = "SELECT 1 FROM pg_database WHERE datname = 'campusjavatest'";
            var rs = stmt.executeQuery(checkDatabase);

            if (!rs.next()) {
                String createDatabase = "CREATE DATABASE campusjavatest";
                stmt.executeUpdate(createDatabase);
                System.out.println("Database created succesfully!!");

            } else {
                System.out.println("Database already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
