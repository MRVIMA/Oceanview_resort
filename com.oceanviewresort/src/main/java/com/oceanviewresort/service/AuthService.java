package com.oceanviewresort.service;

import com.oceanviewresort.dao.UserDAO;
import com.oceanviewresort.model.User;

public class AuthService {
    private UserDAO userDAO;
    
    public AuthService() {
        this.userDAO = new UserDAO();
    }
    
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return userDAO.authenticateUser(username, password);
    }
    
    public boolean register(String username, String password, String role) {
        // Check if user already exists
        if (userExists(username)) {
            return false;
        }
        // Create user with role parameter
        return userDAO.createUser(username, password, role);
    }
    
    public User getUserByUsername(String username) {
        if (username == null) {
            return null;
        }
        return userDAO.getUserByUsername(username);
    }
    
    public boolean userExists(String username) {
        if (username == null) {
            return false;
        }
        return userDAO.userExists(username);
    }
    
    public boolean updateUserPassword(String username, String newPassword) {
        if (username == null || newPassword == null) {
            return false;
        }
        return userDAO.updateUserPassword(username, newPassword);
    }
    
    public boolean deleteUser(String username) {
        if (username == null) {
            return false;
        }
        return userDAO.deleteUser(username);
    }
}
