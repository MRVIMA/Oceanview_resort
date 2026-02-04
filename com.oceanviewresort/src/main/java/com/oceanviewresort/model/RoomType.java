package com.oceanviewresort.model;

public enum RoomType {
    DELUXE(5000.0),
    SUITE(8000.0),
    FAMILY(6000.0),
    PRESIDENTIAL(12000.0);
    
    private final double rate;
    
    RoomType(double rate) {
        this.rate = rate;
    }
    
    public double getRate() {
        return rate;
    }
}