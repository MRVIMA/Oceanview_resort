package com.oceanviewresort.servlet;

import com.oceanviewresort.model.Reservation;
import com.oceanviewresort.service.BillService;
import com.oceanviewresort.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate-bill")
public class CalculateBillServlet extends HttpServlet {
    private ReservationService reservationService;
    private BillService billService;
    
    @Override
    public void init() throws ServletException {
        this.reservationService = new ReservationService();
        this.billService = new BillService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("id"));
        Reservation reservation = reservationService.getReservationById(reservationId);
        
        if (reservation != null) {
            double totalBill = billService.calculateTotalBill(reservation);
            request.setAttribute("reservation", reservation);
            request.setAttribute("totalBill", totalBill);
            request.getRequestDispatcher("/bill-calculation.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Reservation not found");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
