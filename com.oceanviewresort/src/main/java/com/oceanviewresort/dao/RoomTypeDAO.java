package com.oceanviewresort.dao;

import com.oceanviewresort.model.RoomType;
import com.oceanviewresort.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO {

    public int addRoomType(RoomType roomType) throws SQLException {
        String sql = "INSERT INTO roomtype (type_name, description, base_price, capacity, amenities) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, roomType.getType_name());
            statement.setString(2, roomType.getDescription());
            statement.setDouble(3, roomType.getBase_price());
            statement.setInt(4, roomType.getCapacity());
            statement.setString(5, roomType.getAmenities());
            
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating room type failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Returns the newly created ID
                } else {
                    throw new SQLException("Creating room type failed, no ID obtained.");
                }
            }
        }
    }

    public List<RoomType> getAllRoomTypes() throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();
        String sql = "SELECT * FROM roomtype";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            
            while (result.next()) {
                RoomType roomType = new RoomType();
                roomType.setRoom_type_id(result.getInt("room_type_id"));
                roomType.setType_name(result.getString("type_name"));
                roomType.setDescription(result.getString("description"));
                roomType.setBase_price(result.getDouble("base_price"));
                roomType.setCapacity(result.getInt("capacity"));
                roomType.setAmenities(result.getString("amenities"));
                roomTypes.add(roomType);
            }
        }
        return roomTypes;
    }
    
    public RoomType getRoomTypeById(int room_type_id) throws SQLException {
        String sql = "SELECT * FROM RoomType WHERE room_type_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, room_type_id);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                RoomType roomType = new RoomType();
                roomType.setRoom_type_id(result.getInt("room_type_id"));
                roomType.setType_name(result.getString("type_name"));
                roomType.setDescription(result.getString("description"));
                roomType.setBase_price(result.getDouble("base_price"));
                roomType.setCapacity(result.getInt("capacity"));
                roomType.setAmenities(result.getString("amenities"));
                return roomType;
            }
        }
        return null;
    }

    public boolean updateRoomType(RoomType roomType) throws SQLException {
        String sql = "UPDATE RoomType SET type_name = ?, description = ?, base_price = ?, capacity = ?, amenities = ? WHERE room_type_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, roomType.getType_name());
            statement.setString(2, roomType.getDescription());
            statement.setDouble(3, roomType.getBase_price());
            statement.setInt(4, roomType.getCapacity());
            statement.setString(5, roomType.getAmenities());
            statement.setInt(6, roomType.getRoom_type_id());
            
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deleteRoomType(int room_type_id) throws SQLException {
        String sql = "DELETE FROM RoomType WHERE room_type_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, room_type_id);
            
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        }
    }
}