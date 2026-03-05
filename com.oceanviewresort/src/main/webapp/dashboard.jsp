<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Menu - Ocean View Resort</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f8ff; margin: 0; padding: 20px; }
        .container { max-width: 600px; margin: auto; background-color: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); padding: 30px; text-align: center; }
        h2 { color: #007bff; margin-bottom: 5px; }
        .welcome-text { color: #666; margin-bottom: 30px; font-size: 16px; }
        .menu-options a { display: block; background-color: #e6f7ff; color: #007bff; text-decoration: none; padding: 15px; margin: 15px 0; border-radius: 5px; font-size: 18px; font-weight: bold; transition: 0.3s; }
        .menu-options a:hover { background-color: #cceeff; }
        .logout-btn { display: block; background-color: #dc3545 !important; color: white !important; margin-top: 30px !important; }
        .logout-btn:hover { background-color: #c82333 !important; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Ocean View Resort Dashboard</h2>
        <div class="welcome-text">Welcome back, <strong>${sessionScope.username}</strong>!</div>
        
        <div class="menu-options">
       		<c:if test="${sessionScope.role == 'Admin'}">
        		<a href="add-user.jsp" style="background-color: #f0f4ff; border: 1px dashed #007bff;">Register New User (Admin Only)</a>
    		</c:if>
            <a href="add-reservation.jsp">Add New Reservation</a>
            <a href="display-reservation-form.jsp">View Reservations</a>
            <a href="bill-calculation.jsp">Calculate Bill</a>
            <a href="help.jsp">Help & Support</a>
            
            <a href="logout" class="logout-btn">Logout</a>
        </div>
    </div>
</body>
</html>