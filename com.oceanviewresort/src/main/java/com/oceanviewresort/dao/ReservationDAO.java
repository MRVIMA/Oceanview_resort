package com.oceanviewresort.dao;

import com.oceanviewresort.model.Reservation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationDAO {
    private static Map<Integer, Reservation> reservationDatabase = new HashMap<>();
    private static AtomicInteger reservationCounter = new AtomicInteger(1);
    
    public int addReservation(Reservation reservation) {
        int reservationId = reservationCounter.getAndIncrement();
        reservation.setReservationId(reservationId);
        reservationDatabase.put(reservationId, reservation);
        return reservationId;
    }
    
    public Reservation getReservationById(int reservationId) {
        return reservationDatabase.get(reservationId);
    }
    
    public boolean updateReservation(Reservation reservation) {
        if (reservationDatabase.containsKey(reservation.getReservationId())) {
            reservationDatabase.put(reservation.getReservationId(), reservation);
            return true;
        }
        return false;
    }
    
    public boolean deleteReservation(int reservationId) {
        return reservationDatabase.remove(reservationId) != null;
    }
}