package com.oceanviewresort.model;

public class RoomType {
    private int id;
    private String typeName;
    private String description;
    private int maxGuests;
    private double pricePerNight;

    public RoomType() {}
    
    public RoomType(int id, String typeName, String description, int maxGuests, double pricePerNight) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
        this.maxGuests = maxGuests;
        this.pricePerNight = pricePerNight;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getMaxGuests() {
        return maxGuests;
    }
    
    public double getPricePerNight() {
        return pricePerNight;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }
    
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", description='" + description + '\'' +
                ", maxGuests=" + maxGuests +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}
