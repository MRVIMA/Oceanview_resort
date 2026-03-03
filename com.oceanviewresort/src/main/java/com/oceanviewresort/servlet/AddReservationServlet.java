package com.oceanviewresort.servlet;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.model.RoomType;
import com.oceanviewresort.service.ReservationService;

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
        this.reservationService = new ReservationService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/add-reservation.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            int guestId = Integer.parseInt(request.getParameter("guestId"));
            RoomType roomType = RoomType.valueOf(request.getParameter("roomType"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = sdf.parse(request.getParameter("checkInDate"));
            Date checkOutDate = sdf.parse(request.getParameter("checkOutDate"));
            
            Reservation reservation = new Reservation();
            reservation.setGuestId(guestId);
            reservation.setRoomType(roomType);
            reservation.setCheckInDate(checkInDate);
            reservation.setCheckOutDate(checkOutDate);
            reservation.setStatus("CONFIRMED");
            
            boolean success = reservationService.addReservation(reservation);
            
            if (success) {
                request.setAttribute("message", "Reservation added successfully!");
                request.getRequestDispatcher("/add-reservation.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Failed to add reservation. Please try again.");
                request.getRequestDispatcher("/add-reservation.jsp").forward(request, response);
            }
        } catch (ParseException e) {
            request.setAttribute("error", "Invalid date format. Use yyyy-MM-dd");
            request.getRequestDispatcher("/add-reservation.jsp").forward(request, response);
        }
    }
}
