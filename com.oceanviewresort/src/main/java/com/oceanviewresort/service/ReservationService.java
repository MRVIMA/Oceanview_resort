package com.oceanviewresort.service;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.dao.ReservationDAO;
import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO;
    
    public ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }
    
    public boolean addReservation(Reservation reservation) {
        try {
            return reservationDAO.insertReservation(reservation);
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
    
    public double calculateTotalAmount(int roomTypeId, String checkInDate, String checkOutDate) {
        try {
            return reservationDAO.calculateTotalAmount(roomTypeId, checkInDate, checkOutDate);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}