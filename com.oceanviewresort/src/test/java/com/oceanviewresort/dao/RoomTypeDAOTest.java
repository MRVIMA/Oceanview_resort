package com.oceanviewresort.dao;

import com.oceanviewresort.model.RoomType;
import java.sql.SQLException;
import java.util.List;

public class RoomTypeDAOTest {

    public static void main(String[] args) {
        System.out.println("--- TESTING ROOM TYPE DAO ---");
        RoomTypeDAO roomTypeDAO = new RoomTypeDAO();

        try {
            List<RoomType> roomTypes = roomTypeDAO.getAllRoomTypes();
            System.out.println("SUCCESS: Found " + roomTypes.size() + " room types.");
            
            for (RoomType rt : roomTypes) {
                System.out.println(" - " + rt.getType_name() + " ($" + rt.getBase_price() + "/night)");
            }

            if (!roomTypes.isEmpty()) {
                int firstId = roomTypes.get(0).getRoom_type_id();
                RoomType specificRoom = roomTypeDAO.getRoomTypeById(firstId);
                System.out.println("SUCCESS: Retrieved specific room: " + specificRoom.getType_name());
            }

        } catch (SQLException e) {
            System.out.println("FAILED: Database error occurred.");
            e.printStackTrace();
        }
    }
}