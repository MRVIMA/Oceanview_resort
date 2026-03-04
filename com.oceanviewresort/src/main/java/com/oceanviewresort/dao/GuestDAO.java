package com.oceanviewresort.dao;

import com.oceanviewresort.model.Guest;
import com.oceanviewresort.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    public int addGuest(Guest guest) throws SQLException {
        String sql = "INSERT INTO Guest (first_name, last_name, email, phone, address) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, guest.getFirst_name());
            statement.setString(2, guest.getLast_name());
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
    
    public Guest getGuestById(int guest_id) throws SQLException {
        String sql = "SELECT * FROM Guest WHERE guest_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, guest_id);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                Guest guest = new Guest();
                guest.setGuest_id(result.getInt("guest_id"));
                guest.setFirst_name(result.getString("first_name"));
                guest.setLast_name(result.getString("last_name"));
                guest.setEmail(result.getString("email"));
                guest.setPhone(result.getString("phone"));
                guest.setAddress(result.getString("address"));
                return guest;
            }
        }
        return null;
    }
    
    public List<Guest> getAllGuests() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String sql = "SELECT * FROM Guest";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            
            while (result.next()) {
                Guest guest = new Guest();
                guest.setGuest_id(result.getInt("guest_id"));
                guest.setFirst_name(result.getString("first_name"));
                guest.setLast_name(result.getString("last_name"));
                guest.setEmail(result.getString("email"));
                guest.setPhone(result.getString("phone"));
                guest.setAddress(result.getString("address"));
                guests.add(guest);
            }
        }
        return guests;
    }
}