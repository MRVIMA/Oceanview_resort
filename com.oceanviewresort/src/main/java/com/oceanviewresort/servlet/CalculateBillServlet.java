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
import java.sql.SQLException;

@WebServlet("/calculate-bill")
public class CalculateBillServlet extends HttpServlet {
    private ReservationService reservationService;
    private BillService billService;
    
    @Override
    public void init() throws ServletException {
        reservationService = new ReservationService();
        billService = new BillService();
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
                    double billAmount = billService.calculateBill(reservation);
                    request.setAttribute("reservation", reservation);
                    request.setAttribute("billAmount", billAmount);
                } else {
                    request.setAttribute("errorMessage", "Reservation not found");
                }
            }
            
            request.getRequestDispatcher("/bill-calculation.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid reservation ID");
            doGet(request, response);
        }
    }
}