<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reservations</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>All Reservations</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Guest ID</th>
                <th>Room Type</th>
                <th>Check-in Date</th>
                <th>Check-out Date</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="reservation" items="${reservations}">
                <tr>
                    <td>${reservation.id}</td>
                    <td>${reservation.guestId}</td>
                    <td>${reservation.roomType}</td>
                    <td>${reservation.checkInDate}</td>
                    <td>${reservation.checkOutDate}</td>
                    <td>${reservation.status}</td>
                    <td><a href="calculate-bill?id=${reservation.id}">Calculate Bill</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
