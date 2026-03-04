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
    public List<RoomType> getAllRoomTypes() throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();
        String sql = "SELECT * FROM RoomType";
        
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
}