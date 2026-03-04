<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Reservation - Ocean View Resort</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            margin: 0;
            padding: 20px;
        }

        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            max-width: 600px;
            margin: auto;
        }

        h2 {
            text-align: center;
            color: #007bff;
        }

        input[type="text"], input[type="email"], input[type="tel"], input[type="date"] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        select {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Add New Reservation</h2>
    <form action="add-reservation" method="post">
        <input type="text" name="first_name" placeholder="First Name" required><br>
        <input type="text" name="last_name" placeholder="Last Name" required><br>
        <input type="email" name="email" placeholder="Email Address" required><br>
        <input type="tel" name="phone" placeholder="Phone Number"><br>
        <textarea name="address" placeholder="Address"></textarea><br>
        
        <select name="room_type_id" required>
            <option value="">Select Room Type</option>
            <c:forEach items="${roomTypes}" var="roomType">
                <option value="${roomType.room_type_id}">
                    ${roomType.type_name} - $${roomType.base_price}/night
                </option>
            </c:forEach>
        </select><br>
        
        <input type="date" name="check_in_date" required><br>
        <input type="date" name="check_out_date" required><br>
        
        <button type="submit">Add Reservation</button>
    </form>
</div>
</body>
</html>
