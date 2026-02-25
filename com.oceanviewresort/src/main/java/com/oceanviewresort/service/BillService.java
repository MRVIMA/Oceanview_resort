package com.oceanviewresort.service;

import com.oceanviewresort.model.Reservation;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;

public class BillService {
    
    public double calculateBill(Reservation reservation) {
        // Calculate the number of days between check-in and check-out dates
        long numberOfDays = ChronoUnit.DAYS.between(
            reservation.getCheckInDate(),
            reservation.getCheckOutDate()
        );
        
        // Calculate total bill based on room price per night * number of nights
        double totalBill = reservation.getRoomType().getPricePerNight() * numberOfDays;
        
        return totalBill;
    }
}