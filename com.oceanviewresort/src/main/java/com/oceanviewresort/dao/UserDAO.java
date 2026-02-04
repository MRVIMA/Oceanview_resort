package com.oceanviewresort.dao;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private static Map<String, String> userCredentials = new HashMap<>();
    
    static {
        userCredentials.put("admin", "password123");
        userCredentials.put("manager", "manager123");
    }
    
    public boolean authenticate(String username, String password) {
        return userCredentials.containsKey(username) && 
               userCredentials.get(username).equals(password);
    }
}