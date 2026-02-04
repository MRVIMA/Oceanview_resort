package com.oceanviewresort.servlet;

import com.oceanviewresort.service.ReservationService;
import com.oceanviewresort.model.Reservation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/display-reservation")
public class DisplayReservationServlet extends HttpServlet {
    private ReservationService reservationService;
    
    @Override
    public void init() throws ServletException {
        reservationService = new ReservationService();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            Reservation reservation = reservationService.getReservation(reservationId);
            
            if (reservation != null) {
                request.setAttribute("reservation", reservation);
                request.getRequestDispatcher("display-reservation.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Reservation not found!");
                request.getRequestDispatcher("display-reservation.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid reservation ID format!");
            request.getRequestDispatcher("display-reservation.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error retrieving reservation: " + e.getMessage());
            request.getRequestDispatcher("display-reservation.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("display-reservation.jsp").forward(request, response);
    }
}