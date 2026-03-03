package com.oceanviewresort.model;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int guestId;
    private int roomTypeId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalAmount;
    private String status;
    
    // Default constructor
    public Reservation() {}
    
    // Constructor with parameters
    public Reservation(int reservationId, int guestId, int roomTypeId, 
                      Date checkInDate, Date checkOutDate, double totalAmount, String status) {
        this.reservationId = reservationId;
        this.guestId = guestId;
        this.roomTypeId = roomTypeId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    
    // Getters
    public int getReservationId() {
        return reservationId;
    }
    
    public int getGuestId() {
        return guestId;
    }
    
    public int getRoomTypeId() {
        return roomTypeId;
    }
    
    public Date getCheckInDate() {
        return checkInDate;
    }
    
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public String getStatus() {
        return status;
    }
    
    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
    
    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
    
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", guestId=" + guestId +
                ", roomTypeId=" + roomTypeId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
