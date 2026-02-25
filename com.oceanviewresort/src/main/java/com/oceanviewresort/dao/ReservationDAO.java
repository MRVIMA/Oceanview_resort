package com.oceanviewresort.dao;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.model.Guest;
import com.oceanviewresort.model.RoomType;
import com.oceanviewresort.util.Database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    
    public int createReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservation (guest_id, room_type_id, check_in_date, check_out_date, number_of_guests, total_amount, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            statement.setInt(1, reservation.getGuest().getId());
            statement.setInt(2, reservation.getRoomType().getId());
            statement.setDate(3, Date.valueOf(reservation.getCheckInDate()));
            statement.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
            statement.setInt(5, reservation.getNumberOfGuests());
            statement.setDouble(6, reservation.getTotalAmount());
            statement.setString(7, reservation.getStatus());
            
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
    
    public Reservation getReservationById(int id) throws SQLException {
        String sql = "SELECT r.id, r.guest_id, r.room_type_id, r.check_in_date, r.check_out_date, r.number_of_guests, r.total_amount, r.status, g.first_name, g.last_name, g.email, g.phone, g.address, rt.name as room_name, rt.description, rt.price_per_night, rt.max_guests " +
                "FROM reservation r " +
                "JOIN guest g ON r.guest_id = g.id " +
                "JOIN room_type rt ON r.room_type_id = rt.id " +
                "WHERE r.id = ?";
        
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Guest guest = new Guest(
                        resultSet.getInt("guest_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                    );
                    
                    RoomType roomType = new RoomType(
                        resultSet.getInt("room_type_id"),
                        resultSet.getString("room_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price_per_night"),
                        resultSet.getInt("max_guests")
                    );
                    
                    return new Reservation(
                        resultSet.getInt("id"),
                        guest,
                        roomType,
                        resultSet.getDate("check_in_date").toLocalDate(),
                        resultSet.getDate("check_out_date").toLocalDate(),
                        resultSet.getInt("number_of_guests"),
                        resultSet.getDouble("total_amount"),
                        resultSet.getString("status")
                    );
                }
            }
        }
        return null;
    }
    
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT r.id, r.guest_id, r.room_type_id, r.check_in_date, r.check_out_date, r.number_of_guests, r.total_amount, r.status, g.first_name, g.last_name, g.email, g.phone, g.address, rt.name as room_name, rt.description, rt.price_per_night, rt.max_guests " +
                "FROM reservation r " +
                "JOIN guest g ON r.guest_id = g.id " +
                "JOIN room_type rt ON r.room_type_id = rt.id " +
                "ORDER BY r.check_in_date DESC";
        
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                Guest guest = new Guest(
                    resultSet.getInt("guest_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
                );
                
                RoomType roomType = new RoomType(
                    resultSet.getInt("room_type_id"),
                    resultSet.getString("room_name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price_per_night"),
                    resultSet.getInt("max_guests")
                );
                
                Reservation reservation = new Reservation(
                    resultSet.getInt("id"),
                    guest,
                    roomType,
                    resultSet.getDate("check_in_date").toLocalDate(),
                    resultSet.getDate("check_out_date").toLocalDate(),
                    resultSet.getInt("number_of_guests"),
                    resultSet.getDouble("total_amount"),
                    resultSet.getString("status")
                );
                reservations.add(reservation);
            }
        }
        return reservations;
    }
    
    public List<Reservation> getReservationsByGuestId(int guestId) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT r.id, r.guest_id, r.room_type_id, r.check_in_date, r.check_out_date, r.number_of_guests, r.total_amount, r.status, g.first_name, g.last_name, g.email, g.phone, g.address, rt.name as room_name, rt.description, rt.price_per_night, rt.max_guests " +
                "FROM reservation r " +
                "JOIN guest g ON r.guest_id = g.id " +
                "JOIN room_type rt ON r.room_type_id = rt.id " +
                "WHERE r.guest_id = ? ORDER BY r.check_in_date DESC";
        
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, guestId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Guest guest = new Guest(
                        resultSet.getInt("guest_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                    );
                    
                    RoomType roomType = new RoomType(
                        resultSet.getInt("room_type_id"),
                        resultSet.getString("room_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price_per_night"),
                        resultSet.getInt("max_guests")
                    );
                    
                    Reservation reservation = new Reservation(
                        resultSet.getInt("id"),
                        guest,
                        roomType,
                        resultSet.getDate("check_in_date").toLocalDate(),
                        resultSet.getDate("check_out_date").toLocalDate(),
                        resultSet.getInt("number_of_guests"),
                        resultSet.getDouble("total_amount"),
                        resultSet.getString("status")
                    );
                    reservations.add(reservation);
                }
            }
        }
        return reservations;
    }
    
    public boolean updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservation SET guest_id=?, room_type_id=?, check_in_date=?, check_out_date=?, number_of_guests=?, total_amount=?, status=? WHERE id=?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, reservation.getGuest().getId());
            statement.setInt(2, reservation.getRoomType().getId());
            statement.setDate(3, Date.valueOf(reservation.getCheckInDate()));
            statement.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
            statement.setInt(5, reservation.getNumberOfGuests());
            statement.setDouble(6, reservation.getTotalAmount());
            statement.setString(7, reservation.getStatus());
            statement.setInt(8, reservation.getId());
            
            return statement.executeUpdate() > 0;
        }
    }
    
    public boolean deleteReservation(int id) throws SQLException {
        String sql = "DELETE FROM reservation WHERE id=?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }
}