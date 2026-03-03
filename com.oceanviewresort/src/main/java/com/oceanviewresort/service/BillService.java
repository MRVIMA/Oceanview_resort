package com.oceanviewresort.service;

import com.oceanviewresort.dao.ReservationDAO;
import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.model.RoomType;

import java.util.Date;

public class BillService {
    private ReservationDAO reservationDAO;
    
    public BillService() {
        this.reservationDAO = new ReservationDAO();
    }
    
    public double calculateTotalBill(Reservation reservation) {
        // Handle null reservation
        if (reservation == null) {
            return 0.0;
        }
        
        // Handle null dates
        if (reservation.getCheckInDate() == null || reservation.getCheckOutDate() == null) {
            return 0.0;
        }
        
        // Calculate based on room type, number of nights, etc.
        double dailyRate = getDailyRate(reservation.getRoomType());
        long diffInMillies = Math.abs(reservation.getCheckOutDate().getTime() - reservation.getCheckInDate().getTime());
        int numberOfNights = (int) (diffInMillies / (1000 * 60 * 60 * 24));
        
        // Ensure at least one night is charged
        if (numberOfNights == 0) {
            numberOfNights = 1;
        }
        
        return dailyRate * numberOfNights;
    }
    
    private double getDailyRate(RoomType roomType) {
        if (roomType == null) {
            return 150.0;
        }
        
        switch (roomType) {
            case DELUXE:
                return 250.0;
            case SUITE:
                return 350.0;
            case FAMILY:
                return 450.0;
            default:
                return 150.0;
        }
    }
    
    // Add additional methods that might be needed
    public double calculateTax(double subtotal) {
        return subtotal * 0.08; // 8% tax
    }
    
    public double calculateTotalWithTax(Reservation reservation) {
        if (reservation == null) {
            return 0.0;
        }
        
        double subtotal = calculateTotalBill(reservation);
        double tax = calculateTax(subtotal);
        return subtotal + tax;
    }
    
    // Additional utility methods
    public double calculateRoomServiceCharges(Reservation reservation) {
        // Placeholder for room service charges calculation
        // In a real implementation, this might fetch from database or calculate based on services used
        return 0.0;
    }
    
    public double calculateAdditionalCharges(Reservation reservation) {
        // Placeholder for additional charges (amenities, etc.)
        return 0.0;
    }
    
    public double calculateTotalBillWithExtras(Reservation reservation) {
        if (reservation == null) {
            return 0.0;
        }
        
        double baseAmount = calculateTotalBill(reservation);
        double tax = calculateTax(baseAmount);
        double roomService = calculateRoomServiceCharges(reservation);
        double additionalCharges = calculateAdditionalCharges(reservation);
        
        return baseAmount + tax + roomService + additionalCharges;
    }
    
    public String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }
}
