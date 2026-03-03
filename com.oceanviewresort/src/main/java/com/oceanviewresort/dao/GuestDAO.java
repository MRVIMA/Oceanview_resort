package com.oceanviewresort.dao;

import com.oceanviewresort.model.Guest;
import com.oceanviewresort.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    
    public int addGuest(Guest guest) throws SQLException {
        String sql = "INSERT INTO Guest (first_name, last_name, email, phone, address) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, guest.getFirstName());
            stmt.setString(2, guest.getLastName());
            stmt.setString(3, guest.getEmail());
            stmt.setString(4, guest.getPhone());
            stmt.setString(5, guest.getAddress());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating guest failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating guest failed, no ID obtained.");
                }
            }
        }
    }
    
    public Guest getGuestById(int guestId) throws SQLException {
        String sql = "SELECT * FROM Guest WHERE guest_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, guestId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Guest guest = new Guest();
                    guest.setGuestId(rs.getInt("guest_id"));
                    guest.setFirstName(rs.getString("first_name"));
                    guest.setLastName(rs.getString("last_name"));
                    guest.setEmail(rs.getString("email"));
                    guest.setPhone(rs.getString("phone"));
                    guest.setAddress(rs.getString("address"));
                    return guest;
                }
            }
        }
        return null;
    }
    
    public List<Guest> getAllGuests() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String sql = "SELECT * FROM Guest";
        
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Guest guest = new Guest();
                guest.setGuestId(rs.getInt("guest_id"));
                guest.setFirstName(rs.getString("first_name"));
                guest.setLastName(rs.getString("last_name"));
                guest.setEmail(rs.getString("email"));
                guest.setPhone(rs.getString("phone"));
                guest.setAddress(rs.getString("address"));
                guests.add(guest);
            }
        }
        return guests;
    }
    
    public boolean updateGuest(Guest guest) throws SQLException {
        String sql = "UPDATE Guest SET first_name = ?, last_name = ?, email = ?, phone = ?, address = ? WHERE guest_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, guest.getFirstName());
            stmt.setString(2, guest.getLastName());
            stmt.setString(3, guest.getEmail());
            stmt.setString(4, guest.getPhone());
            stmt.setString(5, guest.getAddress());
            stmt.setInt(6, guest.getGuestId());
            
            return stmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteGuest(int guestId) throws SQLException {
        String sql = "DELETE FROM Guest WHERE guest_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, guestId);
            return stmt.executeUpdate() > 0;
        }
    }
}
