package com.oceanviewresort.model;

import java.math.BigDecimal;

public class RoomType {
    private int room_type_id;
    private String type_name;
    private String description;
    private double base_price;
    private int capacity;
    private String amenities;

    public RoomType() {}
    
    public RoomType(String type_name, String description, double base_price, int capacity, String amenities) {
        this.type_name = type_name;
        this.description = description;
        this.base_price = base_price;
        this.capacity = capacity;
        this.amenities = amenities;
    }

    public int getRoom_type_id() { return room_type_id; }
    public void setRoom_type_id(int room_type_id) { this.room_type_id = room_type_id; }
    
    public String getType_name() { return type_name; }
    public void setType_name(String type_name) { this.type_name = type_name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getBase_price() { return base_price; }
    public void setBase_price(double base_price) { this.base_price = base_price; }
    
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
}