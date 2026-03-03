package com.oceanviewresort.dao;

import com.oceanviewresort.model.RoomType;
import com.oceanviewresort.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO {
    private Connection connection;

    public RoomTypeDAO() {
        try {
            connection = Database.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addRoomType(RoomType roomType) {
        String sql = "INSERT INTO room_types (type_name, description, price_per_night, max_guests) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roomType.getTypeName());
            statement.setString(2, roomType.getDescription());
            statement.setDouble(3, roomType.getPricePerNight());
            statement.setInt(4, roomType.getMaxGuests());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding room type: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public RoomType getRoomTypeById(int id) {
        String sql = "SELECT * FROM room_types WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                RoomType roomType = new RoomType();
                roomType.setId(resultSet.getInt("id"));
                roomType.setTypeName(resultSet.getString("type_name"));
                roomType.setDescription(resultSet.getString("description"));
                roomType.setPricePerNight(resultSet.getDouble("price_per_night"));
                roomType.setMaxGuests(resultSet.getInt("max_guests"));
                return roomType;
            }
        } catch (SQLException e) {
            System.err.println("Error getting room type by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<RoomType> getAllRoomTypes() {
        List<RoomType> roomTypes = new ArrayList<>();
        String sql = "SELECT * FROM room_types";
        
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                RoomType roomType = new RoomType();
                roomType.setId(resultSet.getInt("id"));
                roomType.setTypeName(resultSet.getString("type_name"));
                roomType.setDescription(resultSet.getString("description"));
                roomType.setPricePerNight(resultSet.getDouble("price_per_night"));
                roomType.setMaxGuests(resultSet.getInt("max_guests"));
                roomTypes.add(roomType);
            }
        } catch (SQLException e) {
            System.err.println("Error getting all room types: " + e.getMessage());
            e.printStackTrace();
        }
        return roomTypes;
    }

    public boolean updateRoomType(RoomType roomType) {
        String sql = "UPDATE room_types SET type_name=?, description=?, price_per_night=?, max_guests=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roomType.getTypeName());
            statement.setString(2, roomType.getDescription());
            statement.setDouble(3, roomType.getPricePerNight());
            statement.setInt(4, roomType.getMaxGuests());
            statement.setInt(5, roomType.getId());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating room type: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRoomType(int id) {
        String sql = "DELETE FROM room_types WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting room type: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
