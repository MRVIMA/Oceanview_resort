package com.oceanviewresort.service;

import com.oceanviewresort.model.Guest;
import com.oceanviewresort.dao.GuestDAO;
import java.util.List;

public class GuestService {
    private GuestDAO guestDAO;
    
    public GuestService() {
        this.guestDAO = new GuestDAO();
    }
    
    public boolean addGuest(Guest guest) {
        try {
            int generatedId = guestDAO.addGuest(guest);
            return generatedId > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Guest getGuestById(int guestId) {
        try {
            return guestDAO.getGuestById(guestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Guest> getAllGuests() {
        try {
            return guestDAO.getAllGuests();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateGuest(Guest guest) {
        try {
            return guestDAO.updateGuest(guest);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteGuest(int guestId) {
        try {
            return guestDAO.deleteGuest(guestId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}