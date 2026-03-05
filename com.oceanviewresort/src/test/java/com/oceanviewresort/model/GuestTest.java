package com.oceanviewresort.model;

import java.time.LocalDateTime;

public class GuestTest {
    public static void main(String[] args) {
        System.out.println("--- TESTING GUEST MODEL ---");

        Guest guest1 = new Guest("Vimukthi", "Hewage", "vima@email.com", "0771234567", "Colombo, Sri Lanka");
        
        if ("Vimukthi".equals(guest1.getFirst_name()) && "vima@email.com".equals(guest1.getEmail())) {
            System.out.println("SUCCESS: Parameterized constructor created Guest correctly.");
        } else {
            System.out.println("FAILED: Constructor failed to map values.");
        }

        Guest guest2 = new Guest();
        guest2.setGuest_id(101);
        guest2.setFirst_name("Jane");
        guest2.setCreated_at(LocalDateTime.now());

        if (guest2.getGuest_id() == 101 && "Jane".equals(guest2.getFirst_name())) {
            System.out.println("SUCCESS: Empty constructor and setters stored data correctly.");
            System.out.println(" - Guest Created At: " + guest2.getCreated_at());
        } else {
            System.out.println("FAILED: Setters/Getters are not functioning correctly.");
        }
    }
}