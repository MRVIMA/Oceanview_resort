<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error - Ocean View Resort</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        .error-card {
            text-align: center;
            padding: 40px;
            border-top: 5px solid #dc3545;
        }
        .icon-box {
            font-size: 50px;
            color: #dc3545;
            margin-bottom: 20px;
        }
        .msg {
            color: #555;
            font-size: 18px;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <div class="container error-card">
        <div class="icon-box">🔍❌</div>
        <h2>Reservation Not Found</h2>
        
        <div class="msg">
            <c:choose>
                <c:when test="${not empty error}">
                    ${error}
                </c:when>
                <c:otherwise>
                    We couldn't find any reservation matching the ID you provided.
                </c:otherwise>
            </c:choose>
        </div>

        <p>Please check the ID on the guest's confirmation slip and try again.</p>
        
        <div style="margin-top: 30px;">
            <a href="display-reservation" class="btn">Try Another ID</a>
            <a href="dashboard.jsp" class="btn" style="background-color: #6c757d; margin-top: 10px;">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>