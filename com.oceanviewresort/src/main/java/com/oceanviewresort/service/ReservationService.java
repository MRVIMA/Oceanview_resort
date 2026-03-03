package com.oceanviewresort.service;

import com.oceanviewresort.dao.ReservationDAO;
import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.model.RoomType;

import java.util.Date;
import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO;
    
    public ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }
    
    public boolean createReservation(Reservation reservation) {
        if (reservation == null) {
            return false;
        }
        
        // Validate required fields
        if (reservation.getGuestId() <= 0 || 
            reservation.getRoomType() == null ||
            reservation.getCheckInDate() == null ||
            reservation.getCheckOutDate() == null) {
            return false;
        }
        
        return reservationDAO.createReservation(reservation);
    }
    
    public Reservation getReservationById(int reservationId) {
        if (reservationId <= 0) {
            return null;
        }
        return reservationDAO.getReservationById(reservationId);
    }
    
    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }
    
    public List<Reservation> getReservationsByGuestId(int guestId) {
        if (guestId <= 0) {
            return null;
        }
        return reservationDAO.getReservationsByGuestId(guestId);
    }
    
    public List<Reservation> getReservationsByDateRange(Date checkInFrom, Date checkInTo) {
        if (checkInFrom == null || checkInTo == null) {
            return null;
        }
        return reservationDAO.getReservationsByDateRange(checkInFrom, checkInTo);
    }
    
    public boolean updateReservation(Reservation reservation) {
        if (reservation == null || reservation.getId() <= 0) {
            return false;
        }
        
        // Validate required fields
        if (reservation.getGuestId() <= 0 || 
            reservation.getRoomType() == null ||
            reservation.getCheckInDate() == null ||
            reservation.getCheckOutDate() == null) {
            return false;
        }
        
        return reservationDAO.updateReservation(reservation);
    }
    
    public boolean deleteReservation(int reservationId) {
        if (reservationId <= 0) {
            return false;
        }
        return reservationDAO.deleteReservation(reservationId);
    }
    
    public boolean isRoomAvailable(RoomType roomType, Date checkInDate, Date checkOutDate) {
        if (roomType == null || checkInDate == null || checkOutDate == null) {
            return false;
        }
        
        // Check for overlapping reservations
        List<Reservation> overlappingReservations = reservationDAO.getOverlappingReservations(
            roomType, checkInDate, checkOutDate);
        
        return overlappingReservations.isEmpty();
    }
    
    public List<Reservation> getUpcomingReservations(Date date) {
        if (date == null) {
            return null;
        }
        return reservationDAO.getUpcomingReservations(date);
    }
    
    public int getTotalReservationsCount() {
        return reservationDAO.getTotalReservationsCount();
    }
    
    public double getAverageReservationValue() {
        return reservationDAO.getAverageReservationValue();
    }
}
