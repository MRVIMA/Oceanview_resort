package com.oceanviewresort.dao;

import com.oceanviewresort.model.Guest;
import java.sql.SQLException;
import java.util.List;

public class GuestDAOTest {

    public static void main(String[] args) {
        System.out.println("--- TESTING GUEST DAO ---");
        GuestDAO guestDAO = new GuestDAO();

        try {
            Guest newGuest = new Guest();
            newGuest.setFirst_name("Vimukthi");
            newGuest.setLast_name("Iroshan");
            newGuest.setEmail("HewageVima@test.com");
            newGuest.setPhone("200-657");
            newGuest.setAddress("123, Galle");

            int generatedId = guestDAO.addGuest(newGuest);
            System.out.println("SUCCESS: Guest added with ID: " + generatedId);

            Guest retrievedGuest = guestDAO.getGuestById(generatedId);
            if (retrievedGuest != null) {
                System.out.println("SUCCESS: Retrieved Guest - " + retrievedGuest.getFirst_name() + " " + retrievedGuest.getLast_name());
            }

            List<Guest> allGuests = guestDAO.getAllGuests();
            System.out.println("SUCCESS: Total guests in database: " + allGuests.size());

        } catch (SQLException e) {
            System.out.println("FAILED: Database error occurred.");
            e.printStackTrace();
        }
    }
}