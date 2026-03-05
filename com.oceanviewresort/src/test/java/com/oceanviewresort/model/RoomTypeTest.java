package com.oceanviewresort.model;

public class RoomTypeTest {
    public static void main(String[] args) {
        System.out.println("--- TESTING ROOMTYPE MODEL ---");

        RoomType room = new RoomType("Deluxe Ocean View", "Spacious room facing the sea.", 150.00, 2, "WiFi, AC, Balcony");
        room.setRoom_type_id(10);

        if ("Deluxe Ocean View".equals(room.getType_name()) && room.getBase_price() == 150.00) {
            System.out.println("SUCCESS: RoomType name and base price are correct.");
        } else {
            System.out.println("FAILED: RoomType data mismatch.");
        }

        if (room.getCapacity() == 2 && room.getAmenities().contains("WiFi")) {
            System.out.println("SUCCESS: Room capacity and amenities stored correctly.");
            System.out.println(" - Amenities: " + room.getAmenities());
        } else {
            System.out.println("FAILED: Capacity or amenities mismatch.");
        }
    }
}