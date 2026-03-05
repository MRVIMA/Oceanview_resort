<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Help Section - Ocean View Resort</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #e0f7fa; margin: 0; padding: 20px; }
        .content { background-color: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); max-width: 800px; margin: auto; }
        h2 { color: #007bff; border-bottom: 2px solid #e0f7fa; padding-bottom: 10px; }
        h3 { color: #333; margin-top: 25px; }
        ul { padding-left: 20px; color: #555; line-height: 1.6; }
        li { margin-bottom: 10px; }
        .back-btn { display: inline-block; background-color: #6c757d; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; margin-top: 20px; }
        .back-btn:hover { background-color: #5a6268; }
    </style>
</head>
<body>
<div class="content">
    <h2>Help Section - Resort Reservation System</h2>
    <p>Welcome to the Ocean View Resort Reservation System. This guide will help you understand how to use this system effectively.</p>
    
    <h3>How to Use:</h3>
    <ul>
        <li><strong>Add New Reservation:</strong> Fill in guest details, select a room type, and pick dates to create a new booking. The system will automatically calculate the total cost.</li>
        <li><strong>Display Reservation Details:</strong> Enter a reservation ID to view complete booking information and guest details.</li>
        <li><strong>Calculate Bill:</strong> Enter a reservation ID to generate a final receipt for the guest upon checkout.</li>
    </ul>

    <h3>Contact Technical Support:</h3>
    <p>If the system crashes or fails to connect to the database, please contact the IT administrator at <strong>support@oceanviewresort.com</strong> or call internal extension <strong>4567</strong>.</p>
    
    <a href="dashboard.jsp" class="back-btn">Return to Dashboard</a>
</div>
</body>
</html>