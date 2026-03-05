package com.oceanviewresort.service;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.dao.ReservationDAO;
import java.time.LocalDate;
import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO;
    
    public ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }
    
    public boolean addReservation(Reservation reservation) {
        try {
            int generatedId = reservationDAO.addReservation(reservation);
            return generatedId > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Reservation getReservationById(int reservationId) {
        try {
            return reservationDAO.getReservationById(reservationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Reservation> getAllReservations() {
        try {
            return reservationDAO.getAllReservations();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public double calculateTotalAmount(int roomTypeId, String checkInDate, String checkOutDate) {
        try {
            LocalDate checkIn = LocalDate.parse(checkInDate);
            LocalDate checkOut = LocalDate.parse(checkOutDate);
            
            return reservationDAO.calculateTotalAmount(roomTypeId, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println("Error parsing dates. Ensure format is YYYY-MM-DD.");
            e.printStackTrace();
            return 0.0;
        }
    }

    public boolean updateReservation(Reservation reservation) {
        try {
            return reservationDAO.updateReservation(reservation);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteReservation(int reservationId) {
        try {
            return reservationDAO.deleteReservation(reservationId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}