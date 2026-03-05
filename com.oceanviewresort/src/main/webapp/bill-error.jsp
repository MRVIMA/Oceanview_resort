<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Billing Error - Ocean View Resort</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        .error-container {
            text-align: center;
            padding: 40px;
        }
        .warning-icon {
            font-size: 60px;
            color: #ffc107;
            margin-bottom: 20px;
        }
        .error-title {
            color: #dc3545;
            font-size: 24px;
            margin-bottom: 15px;
        }
        .error-text {
            color: #666;
            margin-bottom: 30px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container error-container">
        <div class="warning-icon">⚠️</div>
        <h2 class="error-title">Billing Retrieval Failed</h2>
        
        <div class="error-text">
            <c:choose>
                <c:when test="${not empty error}">
                    ${error}
                </c:when>
                <c:otherwise>
                    The system could not find a reservation with the ID provided.
                </c:otherwise>
            </c:choose>
        </div>

        <p>Please double-check the ID and try again. If the problem persists, ensure the reservation has been properly registered in the system.</p>
        
        <div style="margin-top: 30px;">
            <a href="calculate-bill" class="btn">Try Again</a>
            <a href="dashboard.jsp" class="btn" style="background-color: #6c757d; margin-top: 10px;">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>