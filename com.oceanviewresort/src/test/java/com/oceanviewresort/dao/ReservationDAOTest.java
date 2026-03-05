package com.oceanviewresort.dao;

import com.oceanviewresort.model.Reservation;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ReservationDAOTest {

    public static void main(String[] args) {
        System.out.println("--- TESTING RESERVATION DAO ---");
        ReservationDAO reservationDAO = new ReservationDAO();

        try {
            LocalDate checkIn = LocalDate.now().plusDays(1);
            LocalDate checkOut = LocalDate.now().plusDays(4);
            
            int testGuestId = 1;
            int testRoomTypeId = 1;

            double calculatedTotal = reservationDAO.calculateTotalAmount(testRoomTypeId, checkIn, checkOut);
            System.out.println("SUCCESS: Calculated total for 3 nights is $" + calculatedTotal);

            Reservation newRes = new Reservation();
            newRes.setGuest_id(testGuestId);
            newRes.setRoom_type_id(testRoomTypeId);
            newRes.setCheck_in_date(checkIn);
            newRes.setCheck_out_date(checkOut);
            newRes.setTotal_amount(calculatedTotal);
            newRes.setStatus("CONFIRMED");

            int newResId = reservationDAO.addReservation(newRes);
            System.out.println("SUCCESS: Reservation added with ID: " + newResId);

            List<Reservation> allRes = reservationDAO.getAllReservations();
            System.out.println("SUCCESS: Total reservations in database: " + allRes.size());

        } catch (SQLException e) {
            System.out.println("FAILED: Database error occurred. Check if Guest ID and Room Type ID exist!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("FAILED: An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}