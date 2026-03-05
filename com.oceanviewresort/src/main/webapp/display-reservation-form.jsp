<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find Reservation - Ocean View Resort</title>
    <style>
    body { 
    font-family: Arial, sans-serif; 
    background-color: #f0f8ff; 
    margin: 0; 
    padding: 20px; 
}

/* Central White Card Styling */
.container { 
    max-width: 600px; 
    margin: 50px auto; 
    background-color: white; 
    border-radius: 8px; 
    box-shadow: 0 0 10px rgba(0,0,0,0.1); 
    padding: 30px; 
    text-align: center; 
}

/* Titles and Text */
h2 { 
    color: #007bff; 
    margin-bottom: 5px; 
}

.welcome-text, .instruction-text { 
    color: #666; 
    margin-bottom: 30px; 
    font-size: 16px; 
}

/* Form Styling */
form {
    text-align: left; /* Keep labels aligned to the left */
}

label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #555;
}

input[type="number"], input[type="text"], input[type="password"] {
    width: 100%;
    padding: 12px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box; /* Ensures padding doesn't break width */
}

/* Dashboard Menu Links */
.menu-options a { 
    display: block; 
    background-color: #e6f7ff; 
    color: #007bff; 
    text-decoration: none; 
    padding: 15px; 
    margin: 15px 0; 
    border-radius: 5px; 
    font-size: 18px; 
    font-weight: bold; 
    transition: 0.3s; 
}

.menu-options a:hover { 
    background-color: #cceeff; 
}

/* Standard Buttons (Blue) */
button, .btn-primary { 
    background-color: #007bff; 
    color: white; 
    padding: 15px 20px; 
    border: none; 
    border-radius: 5px; 
    cursor: pointer; 
    width: 100%; 
    font-size: 18px; 
    font-weight: bold; 
    transition: 0.3s; 
}

button:hover { 
    background-color: #0056b3; 
}

/* Red Buttons (Logout/Delete) */
.logout-btn { 
    display: block; 
    background-color: #dc3545 !important; 
    color: white !important; 
    padding: 15px 20px;
    border-radius: 5px;
    text-decoration: none;
    font-weight: bold;
    margin-top: 30px !important; 
}

.logout-btn:hover { 
    background-color: #c82333 !important; 
}
    </style>
</head>
<body>
<div class="container">
    <h2>Search Reservation</h2>
    <p style="text-align: center; color: #666;">Enter the unique Reservation ID provided during booking.</p>
    
    <form action="display-reservation" method="post">
        <label for="reservation_id" style="font-weight: bold; color: #555;">Reservation ID:</label>
        <input type="number" name="reservation_id" id="reservation_id" 
               placeholder="e.g. 101" required min="1">
        
        <button type="submit">View Details</button>
    </form>
    
    <div style="margin-top: 20px; text-align: center;">
        <a href="dashboard.jsp" style="color: #007bff; text-decoration: none;">&larr; Back to Dashboard</a>
    </div>
</div>
</body>
</html>