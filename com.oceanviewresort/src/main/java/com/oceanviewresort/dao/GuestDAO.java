package com.oceanviewresort.dao;

import com.oceanviewresort.model.Guest;
import com.oceanviewresort.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    
    public int createGuest(Guest guest) throws SQLException {
        String sql = "INSERT INTO guest (first_name, last_name, email, phone, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, guest.getFirstName());
            statement.setString(2, guest.getLastName());
            statement.setString(3, guest.getEmail());
            statement.setString(4, guest.getPhone());
            statement.setString(5, guest.getAddress());
            
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating guest failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating guest failed, no ID obtained.");
                }
            }
        }
    }
    
    public Guest getGuestById(int id) throws SQLException {
        String sql = "SELECT * FROM guest WHERE id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Guest(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                    );
                }
            }
        }
        return null;
    }
    
    public Guest getGuestByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM guest WHERE email = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Guest(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                    );
                }
            }
        }
        return null;
    }
    
    public List<Guest> getAllGuests() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String sql = "SELECT * FROM guest";
        
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                Guest guest = new Guest(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
                );
                guests.add(guest);
            }
        }
        return guests;
    }
    
    public boolean updateGuest(Guest guest) throws SQLException {
        String sql = "UPDATE guest SET first_name=?, last_name=?, phone=?, address=? WHERE id=?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, guest.getFirstName());
            statement.setString(2, guest.getLastName());
            statement.setString(3, guest.getPhone());
            statement.setString(4, guest.getAddress());
            statement.setInt(5, guest.getId());
            
            return statement.executeUpdate() > 0;
        }
    }
    
    public boolean deleteGuest(int id) throws SQLException {
        String sql = "DELETE FROM guest WHERE id=?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }
}