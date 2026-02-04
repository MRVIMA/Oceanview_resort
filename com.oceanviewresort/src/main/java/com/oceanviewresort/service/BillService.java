package com.oceanviewresort.service;

import com.oceanviewresort.model.RoomType;
import java.util.Date;

public class BillService {
    
    public double calculateTotalAmount(String roomType, Date checkInDate, Date checkOutDate) {
        long diffInMillies = Math.abs(checkOutDate.getTime() - checkInDate.getTime());
        int numberOfNights = (int) (diffInMillies / (1000 * 60 * 60 * 24));
        
        RoomType rt = RoomType.valueOf(roomType.toUpperCase());
        double ratePerNight = rt.getRate();
        
        return numberOfNights * ratePerNight;
    }
    
    public String generateBill(int reservationId, String guestName, 
                              String roomType, Date checkInDate, Date checkOutDate, 
                              double totalAmount) {
        StringBuilder bill = new StringBuilder();
        bill.append("=== OCEAN VIEW RESORT BILL ===\n");
        bill.append("Reservation ID: ").append(reservationId).append("\n");
        bill.append("Guest Name: ").append(guestName).append("\n");
        bill.append("Room Type: ").append(roomType).append("\n");
        bill.append("Check-in Date: ").append(checkInDate.toString()).append("\n");
        bill.append("Check-out Date: ").append(checkOutDate.toString()).append("\n");
        bill.append("Total Amount: LKR ").append(String.format("%.2f", totalAmount)).append("\n");
        bill.append("==================================\n");
        
        return bill.toString();
    }
}