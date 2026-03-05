package com.oceanviewresort.servlet;

import com.oceanviewresort.dao.ReservationDAO;
import com.oceanviewresort.model.Reservation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/display-reservation")
public class DisplayReservationServlet extends HttpServlet {
    private ReservationDAO reservationDAO;

    @Override
    public void init() throws ServletException {
        reservationDAO = new ReservationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idParam = request.getParameter("reservation_id");
            if (idParam == null || idParam.isEmpty()) {
                throw new NumberFormatException("ID cannot be empty");
            }
            
            int reservationId = Integer.parseInt(idParam);
            Reservation reservation = reservationDAO.getReservationById(reservationId);

            if (reservation != null) {
                request.setAttribute("reservation", reservation);
                request.getRequestDispatcher("display-reservation.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Reservation not found");
                request.getRequestDispatcher("display-reservation-error.jsp").forward(request, response);
            }
        } catch (SQLException | NumberFormatException e) {
            request.setAttribute("error", "Invalid ID format or database error.");
            request.getRequestDispatcher("display-reservation-error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("display-reservation-form.jsp").forward(request, response);
    }
}