<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Reservation</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Add New Reservation</h2>
        <% if (request.getAttribute("message") != null) { %>
            <div class="success-message"><%= request.getAttribute("message") %></div>
        <% } %>
        <% if (request.getAttribute("error") != null) { %>
            <div class="error-message"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <form action="add-reservation" method="post">
            <label for="guestId">Guest ID:</label>
            <input type="number" id="guestId" name="guestId" required>
            
            <label for="roomType">Room Type:</label>
            <select id="roomType" name="roomType" required>
                <option value="STANDARD">Standard</option>
                <option value="DELUXE">Deluxe</option>
                <option value="SUITE">Suite</option>
                <option value="FAMILY">Family</option>
            </select>
            
            <label for="checkInDate">Check-in Date:</label>
            <input type="date" id="checkInDate" name="checkInDate" required>
            
            <label for="checkOutDate">Check-out Date:</label>
            <input type="date" id="checkOutDate" name="checkOutDate" required>
            
            <button type="submit">Add Reservation</button>
        </form>
    </div>
</body>
</html>
