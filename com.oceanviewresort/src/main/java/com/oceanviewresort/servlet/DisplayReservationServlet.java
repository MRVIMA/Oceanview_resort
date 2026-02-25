package com.oceanviewresort.servlet;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/display-reservation")
public class DisplayReservationServlet extends HttpServlet {
    private ReservationService reservationService;
    
    @Override
    public void init() throws ServletException {
        reservationService = new ReservationService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String reservationIdStr = request.getParameter("reservationId");
            
            if (reservationIdStr != null && !reservationIdStr.isEmpty()) {
                int reservationId = Integer.parseInt(reservationIdStr);
                Reservation reservation = reservationService.getReservationById(reservationId);
                
                if (reservation != null) {
                    request.setAttribute("reservation", reservation);
                } else {
                    request.setAttribute("errorMessage", "Reservation not found");
                }
            } else {
                // Display all reservations
                request.setAttribute("reservations", reservationService.getAllReservations());
            }
            
            request.getRequestDispatcher("/display-reservation.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid reservation ID");
            doGet(request, response);
        }
    }
}