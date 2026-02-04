package com.oceanviewresort.servlet;

import com.oceanviewresort.service.BillService;
import com.oceanviewresort.service.ReservationService;
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

@WebServlet("/calculate-bill")
public class CalculateBillServlet extends HttpServlet {
    private BillService billService;
    private ReservationService reservationService;
    
    @Override
    public void init() throws ServletException {
        billService = new BillService();
        reservationService = new ReservationService();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            String guestName = request.getParameter("guestName");
            String roomType = request.getParameter("roomType");
            String checkInStr = request.getParameter("checkInDate");
            String checkOutStr = request.getParameter("checkOutDate");
            
            // Parse dates
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = sdf.parse(checkInStr);
            Date checkOutDate = sdf.parse(checkOutStr);
            
            // Calculate total amount
            double totalAmount = billService.calculateTotalAmount(roomType, checkInDate, checkOutDate);
            
            // Generate bill
            String billDetails = billService.generateBill(reservationId, guestName, roomType, 
                                                        checkInDate, checkOutDate, totalAmount);
            
            request.setAttribute("bill", billDetails);
            request.getRequestDispatcher("calculate-bill.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid reservation ID format!");
            request.getRequestDispatcher("calculate-bill.jsp").forward(request, response);
        } catch (ParseException e) {
            request.setAttribute("error", "Invalid date format. Please use yyyy-MM-dd");
            request.getRequestDispatcher("calculate-bill.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error calculating bill: " + e.getMessage());
            request.getRequestDispatcher("calculate-bill.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("calculate-bill.jsp").forward(request, response);
    }
}