package com.oceanviewresort.servlet;

import com.oceanviewresort.service.ReservationService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-reservation")
public class DeleteReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationService reservationService;

    public void init() {
        reservationService = new ReservationService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("reservation_id"));
        
        boolean success = reservationService.deleteReservation(id);

        if (success) {
            response.sendRedirect("dashboard.jsp?msg=deleted");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}