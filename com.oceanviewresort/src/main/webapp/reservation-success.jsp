<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reservation Successful - Ocean View Resort</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #e8f5e9; margin: 0; padding: 40px; text-align: center; }
        .container { background-color: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); max-width: 500px; margin: auto; border-top: 5px solid #28a745; }
        h2 { color: #28a745; margin-bottom: 10px; }
        .success-icon { font-size: 50px; color: #28a745; margin-bottom: 15px; }
        .res-id { font-size: 24px; font-weight: bold; color: #333; background-color: #f1f1f1; padding: 15px; border-radius: 4px; margin: 20px 0; display: inline-block; }
        .btn { display: inline-block; background-color: #007bff; color: white; padding: 12px 25px; text-decoration: none; border-radius: 4px; font-size: 16px; margin-top: 20px; transition: 0.3s; }
        .btn:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <div class="success-icon">✓</div>
        <h2>Reservation Confirmed!</h2>
        <p>The guest's booking has been successfully saved to the database.</p>
        
        <div class="res-id">
            Confirmation ID: #${reservationId}
        </div>
        
        <p style="color: #666; font-size: 14px;">Please provide this ID to the guest for their records.</p>
        
        <a href="dashboard.jsp" class="btn">Return to Dashboard</a>
    </div>
</body>
</html>