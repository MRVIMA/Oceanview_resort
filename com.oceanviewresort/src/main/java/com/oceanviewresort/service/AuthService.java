package com.oceanviewresort.service;

import com.oceanviewresort.dao.UserDAO;
import com.oceanviewresort.model.User;

import java.sql.SQLException;

public class AuthService {
    
    private UserDAO userDAO;
    
    public AuthService() {
        this.userDAO = new UserDAO();
    }
    
    public User authenticate(String username, String password) throws SQLException {
        return userDAO.authenticateUser(username, password);
    }
    
    public boolean registerUser(String username, String password, String role) throws SQLException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        return userDAO.createUser(user);
    }
}