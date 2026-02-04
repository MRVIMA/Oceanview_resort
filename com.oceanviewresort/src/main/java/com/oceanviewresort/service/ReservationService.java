package com.oceanviewresort.service;

import com.oceanviewresort.dao.GuestDAO;
import com.oceanviewresort.dao.ReservationDAO;
import com.oceanviewresort.model.Guest;
import com.oceanviewresort.model.Reservation;

import java.util.Date;

public class ReservationService {
    private GuestDAO guestDAO;
    private ReservationDAO reservationDAO;
    
    public ReservationService() {
        this.guestDAO = new GuestDAO();
        this.reservationDAO = new ReservationDAO();
    }
    
    public int addGuest(String name, String address, String contactNumber) {
        Guest guest = new Guest(0, name, address, contactNumber);
        return guestDAO.addGuest(guest);
    }
    
    public int addReservation(int guestId, String roomType, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(0, guestId, roomType, checkInDate, checkOutDate);
        return reservationDAO.addReservation(reservation);
    }
    
    public Reservation getReservation(int reservationId) {
        return reservationDAO.getReservationById(reservationId);
    }
}