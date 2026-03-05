package com.oceanviewresort.servlet;

import com.oceanviewresort.dao.*;
import com.oceanviewresort.model.Guest;
import com.oceanviewresort.model.Reservation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/add-reservation")
public class AddReservationServlet extends HttpServlet {
    private GuestDAO guestDAO;
    private ReservationDAO reservationDAO;
    private RoomTypeDAO roomTypeDAO;

    @Override
    public void init() throws ServletException {
        guestDAO = new GuestDAO();
        reservationDAO = new ReservationDAO();
        roomTypeDAO = new RoomTypeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            int roomTypeId = Integer.parseInt(request.getParameter("room_type_id"));
            LocalDate checkInDate = LocalDate.parse(request.getParameter("check_in_date"));
            LocalDate checkOutDate = LocalDate.parse(request.getParameter("check_out_date"));

            Guest guest = new Guest();
            guest.setFirst_name(firstName);
            guest.setLast_name(lastName);
            guest.setEmail(email);
            guest.setPhone(phone);
            guest.setAddress(address);

            int guestId = guestDAO.addGuest(guest);

            double totalAmount = reservationDAO.calculateTotalAmount(roomTypeId, checkInDate, checkOutDate);

            Reservation reservation = new Reservation();
            reservation.setGuest_id(guestId);
            reservation.setRoom_type_id(roomTypeId);
            reservation.setCheck_in_date(checkInDate);
            reservation.setCheck_out_date(checkOutDate);
            reservation.setTotal_amount(totalAmount);
            reservation.setStatus("CONFIRMED");

            int reservationId = reservationDAO.addReservation(reservation);

            request.setAttribute("reservationId", reservationId);
            request.getRequestDispatcher("reservation-success.jsp").forward(request, response);

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to create reservation. Please check your inputs.");
            request.getRequestDispatcher("add-reservation.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("roomTypes", roomTypeDAO.getAllRoomTypes());
            request.getRequestDispatcher("add-reservation.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}