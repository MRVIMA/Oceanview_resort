package com.oceanviewresort.service;

import com.oceanviewresort.dao.ReservationDAO;
import com.oceanviewresort.model.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationService {
    
    private ReservationDAO reservationDAO;
    
    public ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }
    
    public int createReservation(Reservation reservation) throws SQLException {
        return reservationDAO.createReservation(reservation);
    }
    
    public Reservation getReservationById(int id) throws SQLException {
        return reservationDAO.getReservationById(id);
    }
    
    public List<Reservation> getAllReservations() throws SQLException {
        return reservationDAO.getAllReservations();
    }
    
    public List<Reservation> getReservationsByGuestId(int guestId) throws SQLException {
        return reservationDAO.getReservationsByGuestId(guestId);
    }
    
    public boolean updateReservation(Reservation reservation) throws SQLException {
        return reservationDAO.updateReservation(reservation);
    }
    
    public boolean deleteReservation(int id) throws SQLException {
        return reservationDAO.deleteReservation(id);
    }
}