<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reservation Management - Ocean View Resort</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body { font-family: Arial, sans-serif; background-color: #e0f7fa; margin: 0; padding: 20px; }
        .container { background-color: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); max-width: 650px; margin: auto; }
        h2 { color: #007bff; text-align: center; border-bottom: 2px solid #e0f7fa; padding-bottom: 10px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px 15px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f8f9fa; color: #333; width: 40%; }
        td { color: #555; font-weight: bold; }
        
        .action-section { margin-top: 30px; padding-top: 20px; border-top: 2px solid #f0f0f0; }
        .update-box { display: flex; align-items: center; gap: 10px; margin-bottom: 15px; }
        
        /* Button Styles */
        .btn-update { background-color: #28a745; color: white; border: none; padding: 10px 15px; border-radius: 4px; cursor: pointer; font-weight: bold; }
        .btn-delete { background-color: #dc3545; color: white; border: none; padding: 10px 15px; border-radius: 4px; cursor: pointer; font-weight: bold; width: 100%; margin-top: 10px; }
        .btn-back { display: block; background-color: #6c757d; color: white; padding: 12px; text-align: center; text-decoration: none; border-radius: 4px; margin-top: 15px; }
        
        select { padding: 8px; border-radius: 4px; border: 1px solid #ccc; flex-grow: 1; }
    </style>
    
    <script>
        function confirmDelete() {
            return confirm("Are you sure you want to permanently delete this reservation?");
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Manage Reservation</h2>
        
        <table>
            <tr><th>Reservation ID</th><td>#${reservation.reservation_id}</td></tr>
            <tr><th>Guest ID</th><td>${reservation.guest_id}</td></tr>
            <tr><th>Room Type ID</th><td>${reservation.room_type_id}</td></tr>
            <tr><th>Check-In</th><td>${reservation.check_in_date}</td></tr>
            <tr><th>Check-Out</th><td>${reservation.check_out_date}</td></tr>
            <tr>
                <th>Current Status</th>
                <td><span class="status-badge" style="background-color: #007bff; color:white; padding: 3px 8px; border-radius: 12px;">${reservation.status}</span></td>
            </tr>
        </table>

        <div class="action-section">
            <form action="update-reservation" method="post" class="update-box">
                <input type="hidden" name="reservation_id" value="${reservation.reservation_id}">
                <select name="status">
                    <option value="CONFIRMED" ${reservation.status == 'CONFIRMED' ? 'selected' : ''}>CONFIRMED</option>
                    <option value="CHECKED_IN" ${reservation.status == 'CHECKED_IN' ? 'selected' : ''}>CHECKED IN</option>
                    <option value="CHECKED_OUT" ${reservation.status == 'CHECKED_OUT' ? 'selected' : ''}>CHECKED OUT</option>
                    <option value="CANCELLED" ${reservation.status == 'CANCELLED' ? 'selected' : ''}>CANCELLED</option>
                </select>
                <button type="submit" class="btn-update">Update Status</button>
            </form>

            <form action="delete-reservation" method="post" onsubmit="return confirmDelete()">
                <input type="hidden" name="reservation_id" value="${reservation.reservation_id}">
                <button type="submit" class="btn-delete">Delete Reservation</button>
            </form>
        </div>
        
        <a href="dashboard.jsp" class="btn-back">Return to Dashboard</a>
    </div>
</body>
</html>