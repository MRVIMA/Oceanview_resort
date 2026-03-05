package com.oceanviewresort.service;

import com.oceanviewresort.model.RoomType;
import java.util.List;

public class RoomTypeServiceTest {

    public static void main(String[] args) {
        RoomTypeService roomService = new RoomTypeService();
        System.out.println("=== STARTING ROOM TYPE SERVICE TEST ===\n");

        System.out.println("[TEST 1] Adding a new Room Type...");
        RoomType newType = new RoomType("Ocean Suite", "Luxury suite with panoramic view", 350.00, 2, "Mini Bar, Balcony, WiFi");
        boolean isAdded = roomService.addRoomType(newType);
        
        if (isAdded) {
            System.out.println("SUCCESS: Room Type added to the database.\n");
        } else {
            System.out.println("FAILED: Could not add Room Type. Check Database connection.\n");
        }

        System.out.println("[TEST 2] Fetching all Room Types...");
        List<RoomType> roomList = roomService.getAllRoomTypes();
        
        if (roomList != null && !roomList.isEmpty()) {
            System.out.println("SUCCESS: Found " + roomList.size() + " Room Types.");
            for (RoomType rt : roomList) {
                System.out.println(" -> ID: " + rt.getRoom_type_id() + " | Name: " + rt.getType_name() + " | Price: $" + rt.getBase_price());
            }
            System.out.println();
        } else {
            System.out.println("FAILED: No Room Types found or error occurred.\n");
        }

        if (roomList != null && !roomList.isEmpty()) {
            int testId = roomList.get(0).getRoom_type_id();
            System.out.println("[TEST 3] Fetching Room Type with ID: " + testId);
            RoomType found = roomService.getRoomTypeById(testId);
            
            if (found != null) {
                System.out.println("SUCCESS: Found " + found.getType_name() + "\n");
            } else {
                System.out.println("FAILED: Room Type not found.\n");
            }
        }

        if (roomList != null && !roomList.isEmpty()) {
            RoomType updateTarget = roomList.get(0);
            updateTarget.setType_name("Updated Room Name");
            System.out.println("[TEST 4] Updating Room Type ID " + updateTarget.getRoom_type_id() + "...");
            
            boolean isUpdated = roomService.updateRoomType(updateTarget);
            if (isUpdated) {
                System.out.println("SUCCESS: Room details updated.\n");
            } else {
                System.out.println("FAILED: Update operation failed.\n");
            }
        }

        System.out.println("=== ROOM TYPE SERVICE TEST COMPLETE ===");
    }
}