package com.oceanviewresort.dao;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    
    public int addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservation (guest_id, room_type_id, check_in_date, check_out_date, total_amount, status) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setInt(1, reservation.getGuest_id());
            statement.setInt(2, reservation.getRoom_type_id());
            statement.setDate(3, java.sql.Date.valueOf(reservation.getCheck_in_date()));
            statement.setDate(4, java.sql.Date.valueOf(reservation.getCheck_out_date()));
            statement.setDouble(5, reservation.getTotal_amount());
            statement.setString(6, reservation.getStatus());
            
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating reservation failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating reservation failed, no ID obtained.");
                }
            }
        }
    }
    
    public Reservation getReservationById(int reservation_id) throws SQLException {
        String sql = "SELECT * FROM reservation WHERE reservation_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, reservation_id);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservation_id(result.getInt("reservation_id"));
                reservation.setGuest_id(result.getInt("guest_id"));
                reservation.setRoom_type_id(result.getInt("room_type_id"));
                reservation.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                reservation.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                reservation.setTotal_amount(result.getDouble("total_amount"));
                reservation.setStatus(result.getString("status"));
                return reservation;
            }
        }
        return null;
    }
    
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservation";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            
            while (result.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservation_id(result.getInt("reservation_id"));
                reservation.setGuest_id(result.getInt("guest_id"));
                reservation.setRoom_type_id(result.getInt("room_type_id"));
                reservation.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                reservation.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                reservation.setTotal_amount(result.getDouble("total_amount"));
                reservation.setStatus(result.getString("status"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }
    
    public boolean updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservation SET guest_id = ?, room_type_id = ?, check_in_date = ?, check_out_date = ?, total_amount = ?, status = ? WHERE reservation_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, reservation.getGuest_id());
            statement.setInt(2, reservation.getRoom_type_id());
            statement.setDate(3, java.sql.Date.valueOf(reservation.getCheck_in_date()));
            statement.setDate(4, java.sql.Date.valueOf(reservation.getCheck_out_date()));
            statement.setDouble(5, reservation.getTotal_amount());
            statement.setString(6, reservation.getStatus());
            statement.setInt(7, reservation.getReservation_id());
            
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deleteReservation(int reservation_id) throws SQLException {
        String sql = "DELETE FROM reservation WHERE reservation_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, reservation_id);
            
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        }
    }
    
    public double calculateTotalAmount(int room_type_id, LocalDate checkIn, LocalDate checkOut) throws SQLException {
        RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
        double basePrice = roomTypeDAO.getRoomTypeById(room_type_id).getBase_price();
        
        long days = java.time.temporal.ChronoUnit.DAYS.between(checkIn, checkOut);
        return basePrice * days;
    }
}