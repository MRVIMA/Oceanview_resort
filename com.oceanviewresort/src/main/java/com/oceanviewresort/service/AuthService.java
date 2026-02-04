package com.oceanviewresort.service;

import com.oceanviewresort.dao.UserDAO;

public class AuthService {
    private UserDAO userDAO;
    
    public AuthService() {
        this.userDAO = new UserDAO();
    }
    
    public boolean login(String username, String password) {
        return userDAO.authenticate(username, password);
    }
}