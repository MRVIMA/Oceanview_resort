package com.oceanviewresort.servlet;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/display-reservation")
public class DisplayReservationServlet extends HttpServlet {
    private ReservationService reservationService;
    
    @Override
    public void init() throws ServletException {
        this.reservationService = new ReservationService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Reservation> reservations = reservationService.getAllReservations();
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("/display-reservation.jsp").forward(request, response);
    }
}
