<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Guest Invoice - Ocean View Resort</title>
    <style>
        body { font-family: 'Courier New', Courier, monospace; background-color: #f4f4f4; margin: 0; padding: 20px; }
        .receipt-container { background-color: white; padding: 40px; border: 1px dashed #ccc; box-shadow: 0 4px 8px rgba(0,0,0,0.1); max-width: 500px; margin: auto; }
        .header { text-align: center; border-bottom: 2px dashed #333; padding-bottom: 20px; margin-bottom: 20px; }
        .header h2 { margin: 0; color: #333; font-family: Arial, sans-serif; }
        .header p { margin: 5px 0 0; color: #666; font-size: 14px; }
        .line-item { display: flex; justify-content: space-between; margin-bottom: 10px; font-size: 16px; color: #333; }
        .total-row { display: flex; justify-content: space-between; margin-top: 20px; padding-top: 20px; border-top: 2px dashed #333; font-size: 20px; font-weight: bold; color: #000; }
        .actions { text-align: center; margin-top: 30px; }
        .btn { background-color: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; font-family: Arial, sans-serif; border: none; cursor: pointer; font-size: 16px; margin: 5px; }
        .btn:hover { background-color: #0056b3; }
        .btn-secondary { background-color: #6c757d; }
        .btn-secondary:hover { background-color: #5a6268; }
        
        /* Hide buttons when printing */
        @media print {
            .actions { display: none; }
            body { background-color: white; }
            .receipt-container { box-shadow: none; border: none; }
        }
    </style>
</head>
<body>
    <div class="receipt-container">
        <div class="header">
            <h2>OCEAN VIEW RESORT</h2>
            <p>123 Coastal Highway, Galle, Sri Lanka</p>
            <p>Tel: +94 11 123 4567</p>
        </div>
        
        <div class="line-item">
            <span>Invoice No:</span>
            <span>#INV-${reservation.reservation_id}</span>
        </div>
        <div class="line-item">
            <span>Guest ID:</span>
            <span>${reservation.guest_id}</span>
        </div>
        <div class="line-item">
            <span>Check-In:</span>
            <span>${reservation.check_in_date}</span>
        </div>
        <div class="line-item">
            <span>Check-Out:</span>
            <span>${reservation.check_out_date}</span>
        </div>
        <div class="line-item" style="margin-top: 15px;">
            <span>Room Status:</span>
            <span style="text-transform: uppercase;">${reservation.status}</span>
        </div>
        
        <div class="total-row">
            <span>TOTAL AMOUNT DUE:</span>
            <span>$${reservation.total_amount}0</span>
        </div>
        
        <div class="header" style="border-top: 2px dashed #333; border-bottom: none; margin-top: 30px; padding-top: 20px;">
            <p>Thank you for choosing Ocean View Resort!</p>
            <p>We hope you enjoyed your stay.</p>
        </div>

        <div class="actions">
            <button class="btn" onclick="window.print()">🖨️ Print Invoice</button>
            <a href="dashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>