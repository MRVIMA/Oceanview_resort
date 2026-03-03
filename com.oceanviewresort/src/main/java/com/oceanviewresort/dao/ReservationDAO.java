package com.oceanviewresort.dao;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    
    public int addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO Reservation (guest_id, room_type_id, check_in_date, check_out_date, total_amount, status) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, reservation.getGuestId());
            stmt.setInt(2, reservation.getRoomTypeId());
            stmt.setDate(3, new java.sql.Date(reservation.getCheckInDate().getTime()));
            stmt.setDate(4, new java.sql.Date(reservation.getCheckOutDate().getTime()));
            stmt.setDouble(5, reservation.getTotalAmount());
            stmt.setString(6, reservation.getStatus());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating reservation failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating reservation failed, no ID obtained.");
                }
            }
        }
    }
    
    public Reservation getReservationById(int reservationId) throws SQLException {
        String sql = "SELECT * FROM Reservation WHERE reservation_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, reservationId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setReservationId(rs.getInt("reservation_id"));
                    reservation.setGuestId(rs.getInt("guest_id"));
                    reservation.setRoomTypeId(rs.getInt("room_type_id"));
                    reservation.setCheckInDate(rs.getDate("check_in_date"));
                    reservation.setCheckOutDate(rs.getDate("check_out_date"));
                    reservation.setTotalAmount(rs.getDouble("total_amount"));
                    reservation.setStatus(rs.getString("status"));
                    return reservation;
                }
            }
        }
        return null;
    }
    
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation ORDER BY created_at DESC";
        
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setGuestId(rs.getInt("guest_id"));
                reservation.setRoomTypeId(rs.getInt("room_type_id"));
                reservation.setCheckInDate(rs.getDate("check_in_date"));
                reservation.setCheckOutDate(rs.getDate("check_out_date"));
                reservation.setTotalAmount(rs.getDouble("total_amount"));
                reservation.setStatus(rs.getString("status"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }
    
    public List<Reservation> getReservationsByGuestId(int guestId) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation WHERE guest_id = ? ORDER BY check_in_date DESC";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, guestId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setReservationId(rs.getInt("reservation_id"));
                    reservation.setGuestId(rs.getInt("guest_id"));
                    reservation.setRoomTypeId(rs.getInt("room_type_id"));
                    reservation.setCheckInDate(rs.getDate("check_in_date"));
                    reservation.setCheckOutDate(rs.getDate("check_out_date"));
                    reservation.setTotalAmount(rs.getDouble("total_amount"));
                    reservation.setStatus(rs.getString("status"));
                    reservations.add(reservation);
                }
            }
        }
        return reservations;
    }
    
    public boolean updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE Reservation SET guest_id = ?, room_type_id = ?, check_in_date = ?, check_out_date = ?, total_amount = ?, status = ? WHERE reservation_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, reservation.getGuestId());
            stmt.setInt(2, reservation.getRoomTypeId());
            stmt.setDate(3, new java.sql.Date(reservation.getCheckInDate().getTime()));
            stmt.setDate(4, new java.sql.Date(reservation.getCheckOutDate().getTime()));
            stmt.setDouble(5, reservation.getTotalAmount());
            stmt.setString(6, reservation.getStatus());
            stmt.setInt(7, reservation.getReservationId());
            
            return stmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteReservation(int reservationId) throws SQLException {
        String sql = "DELETE FROM Reservation WHERE reservation_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, reservationId);
            return stmt.executeUpdate() > 0;
        }
    }
}
