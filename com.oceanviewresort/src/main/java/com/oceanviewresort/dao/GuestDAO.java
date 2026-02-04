package com.oceanviewresort.dao;

import com.oceanviewresort.model.Guest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GuestDAO {
    private static Map<Integer, Guest> guestDatabase = new HashMap<>();
    private static AtomicInteger guestCounter = new AtomicInteger(1);
    
    public int addGuest(Guest guest) {
        int guestId = guestCounter.getAndIncrement();
        guest.setGuestId(guestId);
        guestDatabase.put(guestId, guest);
        return guestId;
    }
    
    public Guest getGuestById(int guestId) {
        return guestDatabase.get(guestId);
    }
    
    public boolean updateGuest(Guest guest) {
        if (guestDatabase.containsKey(guest.getGuestId())) {
            guestDatabase.put(guest.getGuestId(), guest);
            return true;
        }
        return false;
    }
    
    public boolean deleteGuest(int guestId) {
        return guestDatabase.remove(guestId) != null;
    }
}