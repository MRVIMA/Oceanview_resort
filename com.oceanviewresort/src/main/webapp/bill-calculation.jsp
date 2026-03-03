<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Calculation</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Bill Calculation</h2>
        <p><strong>Guest ID:</strong> ${reservation.guestId}</p>
        <p><strong>Room Type:</strong> ${reservation.roomType}</p>
        <p><strong>Check-in Date:</strong> ${reservation.checkInDate}</p>
        <p><strong>Check-out Date:</strong> ${reservation.checkOutDate}</p>
        <p><strong>Total Bill:</strong> $${totalBill}</p>
        <a href="display-reservation.jsp">Back to Reservations</a>
    </div>
</body>
</html>
