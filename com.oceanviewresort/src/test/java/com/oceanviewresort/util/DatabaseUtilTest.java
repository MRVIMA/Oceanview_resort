package com.oceanviewresort.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {

    public static void main(String[] args) {
        System.out.println("--- TESTING DATABASE CONNECTION ---");
        System.out.println("Attempting to connect to 'oceanviewresort_vima'...");

        try (Connection conn = DatabaseUtil.getConnection()) {
            
            if (conn != null && !conn.isClosed()) {
                System.out.println("SUCCESS: You are officially connected to your MySQL Database!");
                System.out.println("Database Product Name: " + conn.getMetaData().getDatabaseProductName());
            } else {
                System.out.println("FAILED: The connection was returned as null or is already closed.");
            }
            
        } catch (SQLException e) {
            System.out.println("\nFAILED: Could not connect to the database. Please check the following:");
            System.out.println("  1. Is your MySQL server (XAMPP/WAMP) currently running?");
            System.out.println("  2. Did you actually create the database named 'oceanviewresort_vima' in phpMyAdmin?");
            System.out.println("  3. Is the 'mysql-connector-j.jar' file added to your project's Build Path?");
            System.out.println("\n--- Error Details ---");
            e.printStackTrace();
        }
    }
}