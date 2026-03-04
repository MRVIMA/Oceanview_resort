package com.oceanviewresort.service;

import com.oceanviewresort.model.RoomType;
import com.oceanviewresort.dao.RoomTypeDAO;
import java.util.List;

public class RoomTypeService {
    private RoomTypeDAO roomTypeDAO;
    
    public RoomTypeService() {
        this.roomTypeDAO = new RoomTypeDAO();
    }
    
    public boolean addRoomType(RoomType roomType) {
        try {
            return roomTypeDAO.insertRoomType(roomType);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public RoomType getRoomTypeById(int roomTypeId) {
        try {
            return roomTypeDAO.getRoomTypeById(roomTypeId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<RoomType> getAllRoomTypes() {
        try {
            return roomTypeDAO.getAllRoomTypes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean updateRoomType(RoomType roomType) {
        try {
            return roomTypeDAO.updateRoomType(roomType);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteRoomType(int roomTypeId) {
        try {
            return roomTypeDAO.deleteRoomType(roomTypeId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}