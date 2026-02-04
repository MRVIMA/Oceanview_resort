package com.oceanviewresort.servlet;

import com.oceanviewresort.service.ReservationService;
import com.oceanviewresort.model.Guest;
import com.oceanviewresort.model.Reservation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/add-reservation")
public class AddReservationServlet extends HttpServlet {
    private ReservationService reservationService;
    
    @Override
    public void init() throws ServletException {
        reservationService = new ReservationService();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            String guestName = request.getParameter("guestName");
            String address = request.getParameter("address");
            String contactNumber = request.getParameter("contactNumber");
            String roomType = request.getParameter("roomType");
            String checkInStr = request.getParameter("checkInDate");
            String checkOutStr = request.getParameter("checkOutDate");
            
            // Parse dates
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = sdf.parse(checkInStr);
            Date checkOutDate = sdf.parse(checkOutStr);
            
            // Add guest
            int guestId = reservationService.addGuest(guestName, address, contactNumber);
            
            // Add reservation
            int reservationId = reservationService.addReservation(guestId, roomType, checkInDate, checkOutDate);
            
            request.setAttribute("message", "Reservation added successfully!");
            request.setAttribute("reservationId", reservationId);
            request.getRequestDispatcher("add-reservation.jsp").forward(request, response);
            
        } catch (ParseException e) {
            request.setAttribute("error", "Invalid date format. Please use yyyy-MM-dd");
            request.getRequestDispatcher("add-reservation.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error adding reservation: " + e.getMessage());
            request.getRequestDispatcher("add-reservation.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("add-reservation.jsp").forward(request, response);
    }
}