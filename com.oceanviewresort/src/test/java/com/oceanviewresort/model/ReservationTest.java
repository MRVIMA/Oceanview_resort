package com.oceanviewresort.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationTest {
    public static void main(String[] args) {
        System.out.println("--- TESTING RESERVATION MODEL ---");

        LocalDate checkIn = LocalDate.of(2026, 6, 1);
        LocalDate checkOut = LocalDate.of(2026, 6, 5);

        Reservation res = new Reservation(1, 2, checkIn, checkOut, 600.00, "CONFIRMED");
        res.setReservation_id(5001);
        res.setCreated_at(LocalDateTime.now());

        if (res.getReservation_id() == 5001 && res.getTotal_amount() == 600.00) {
            System.out.println("SUCCESS: Reservation object holds financial and ID data correctly.");
        } else {
            System.out.println("FAILED: Financial or ID data mismatch.");
        }

        if (res.getCheck_in_date().isEqual(checkIn) && "CONFIRMED".equals(res.getStatus())) {
            System.out.println("SUCCESS: Reservation dates and status mapped correctly.");
            System.out.println(" - Check-Out Date: " + res.getCheck_out_date());
        } else {
            System.out.println("FAILED: Date or status data mismatch.");
        }
    }
}