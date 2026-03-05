package com.oceanviewresort.dao;

import com.oceanviewresort.model.User;
import java.sql.SQLException;

public class UserDAOTest {

    public static void main(String[] args) {
        System.out.println("--- TESTING USER DAO ---");
        UserDAO userDAO = new UserDAO();

        try {
            System.out.println("\n[Testing addUser...]");
            User newUser = new User("test_admin", "testpass", "Admin");
            
            int generatedId = userDAO.createUser(newUser);
            System.out.println("SUCCESS: User added to database with ID: " + generatedId);

            System.out.println("\n[Testing authenticateUser - Valid Credentials...]");
            User loggedInUser = userDAO.authenticateUser("test_admin", "testpass");
            
            if (loggedInUser != null) {
                System.out.println("SUCCESS: Login Approved! Welcome, " + loggedInUser.getUsername());
                System.out.println(" - Assigned Role: " + loggedInUser.getRole());
            } else {
                System.out.println("FAILED: Could not authenticate the user we just created.");
            }

            System.out.println("\n[Testing authenticateUser - Invalid Credentials...]");
            User failedLogin = userDAO.authenticateUser("test_admin", "wrongpassword");
            
            if (failedLogin == null) {
                System.out.println("SUCCESS: System correctly rejected the invalid password.");
            } else {
                System.out.println("FAILED: Security breach! System allowed a bad password.");
            }

        } catch (SQLException e) {
            System.out.println("FAILED: Database error occurred. Check if your 'Users' table exists!");
            e.printStackTrace();
        }
    }
}