package com.oceanviewresort.servlet;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.service.ReservationService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-reservation")
public class UpdateReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationService reservationService;

    public void init() {
        reservationService = new ReservationService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("reservation_id"));
        String newStatus = request.getParameter("status");


        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            reservation.setStatus(newStatus);
            boolean success = reservationService.updateReservation(reservation);
            
            if (success) {
                response.sendRedirect("display-reservation?reservation_id=" + id);
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }
}