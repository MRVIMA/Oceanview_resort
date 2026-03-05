package com.oceanviewresort.service;

import com.oceanviewresort.model.Guest;

public class GuestServiceTest {
    public static void main(String[] args) {
        System.out.println("--- TESTING GUEST SERVICE ---");
        GuestService service = new GuestService();

        Guest testGuest = new Guest("Service", "Tester", "service@test.com", "111-2222", "Test Ave");
        boolean isSaved = service.addGuest(testGuest);

        if (isSaved) {
            System.out.println("SUCCESS: GuestService successfully communicated with the DAO and saved the guest.");
        } else {
            System.out.println("FAILED: Service could not save the guest.");
        }
    }
}