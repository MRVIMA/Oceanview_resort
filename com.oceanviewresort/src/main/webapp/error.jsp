<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>System Error - Ocean View Resort</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8d7da; margin: 0; padding: 40px; text-align: center; }
        .container { background-color: white; padding: 40px; border-radius: 8px; box-shadow: 0 0 15px rgba(0,0,0,0.1); max-width: 500px; margin: auto; border-top: 5px solid #dc3545; }
        h2 { color: #dc3545; margin-bottom: 10px; }
        p { color: #555; font-size: 16px; margin-bottom: 25px; }
        .error-detail { background-color: #f1f1f1; padding: 15px; border-radius: 4px; color: #333; font-family: monospace; text-align: left; margin-bottom: 25px; word-wrap: break-word; }
        a { background-color: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; }
        a:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Something went wrong!</h2>
        <p>The system encountered an unexpected error while processing your request.</p>
        
        <c:if test="${not empty error}">
            <div class="error-detail"><strong>Error Details:</strong> ${error}</div>
        </c:if>
        
        <a href="index.jsp">Back to Dashboard</a>
    </div>
</body>
</html>