package com.oceanviewresort.servlet;

import com.oceanviewresort.dao.GuestDAO;
import com.oceanviewresort.dao.ReservationDAO;
import com.oceanviewresort.dao.RoomTypeDAO;
import com.oceanviewresort.model.*;
import com.oceanviewresort.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/add-reservation")
public class AddReservationServlet extends HttpServlet {
    private ReservationService reservationService;
    private GuestDAO guestDAO;
    private RoomTypeDAO roomTypeDAO;
    
    @Override
    public void init() throws ServletException {
        reservationService = new ReservationService();
        guestDAO = new GuestDAO();
        roomTypeDAO = new RoomTypeDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Fetch available guests and room types for dropdowns
            request.setAttribute("guests", guestDAO.getAllGuests());
            request.setAttribute("roomTypes", roomTypeDAO.getAllRoomTypes());
            request.getRequestDispatcher("/add-reservation.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Get form parameters
            int guestId = Integer.parseInt(request.getParameter("guestId"));
            int roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));
            LocalDate checkInDate = LocalDate.parse(request.getParameter("checkInDate"));
            LocalDate checkOutDate = LocalDate.parse(request.getParameter("checkOutDate"));
            int numberOfGuests = Integer.parseInt(request.getParameter("numberOfGuests"));
            
            // Get guest and room type objects
            Guest guest = guestDAO.getGuestById(guestId);
            RoomType roomType = roomTypeDAO.getRoomTypeById(roomTypeId);
            
            // Create reservation object
            Reservation reservation = new Reservation();
            reservation.setGuest(guest);
            reservation.setRoomType(roomType);
            reservation.setCheckInDate(checkInDate);
            reservation.setCheckOutDate(checkOutDate);
            reservation.setNumberOfGuests(numberOfGuests);
            reservation.setStatus("confirmed");
            
            // Save reservation
            int reservationId = reservationService.createReservation(reservation);
            
            request.setAttribute("successMessage", "Reservation created successfully!");
            response.sendRedirect("display-reservation.jsp?reservationId=" + reservationId);
            
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid input format");
            doGet(request, response);
        }
    }
}