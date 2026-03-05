package com.oceanviewresort.service;

public class ReservationServiceTest {
    public static void main(String[] args) {
        System.out.println("--- TESTING RESERVATION SERVICE ---");
        ReservationService service = new ReservationService();

        String checkInStr = "2026-05-10";
        String checkOutStr = "2026-05-15";
        
        double total = service.calculateTotalAmount(1, checkInStr, checkOutStr);
        
        if (total > 0) {
            System.out.println("SUCCESS: The Service parsed the String dates perfectly and calculated: $" + total);
        } else {
            System.out.println("FAILED: Date parsing failed or database returned $0.0");
        }
    }
}