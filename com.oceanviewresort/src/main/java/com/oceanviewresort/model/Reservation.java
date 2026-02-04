package com.oceanviewresort.model;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int guestId;
    private String roomType;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalAmount;
    
    public Reservation() {}
    
    public Reservation(int reservationId, int guestId, String roomType, 
                      Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.guestId = guestId;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }
    
    public int getGuestId() { return guestId; }
    public void setGuestId(int guestId) { this.guestId = guestId; }
    
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    
    public Date getCheckInDate() { return checkInDate; }
    public void setCheckInDate(Date checkInDate) { this.checkInDate = checkInDate; }
    
    public Date getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }
    
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}