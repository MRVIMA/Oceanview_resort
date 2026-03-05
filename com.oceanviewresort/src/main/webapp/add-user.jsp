<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New User - Ocean View Resort</title>
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

        input[type="text"], input[type="password"], select, textarea {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        textarea {
            resize: vertical;
            height: 80px;
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
            margin-top: 10px;
        }

        button:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: #dc3545;
            background-color: #f8d7da;
            padding: 10px;
            border-radius: 4px;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>System User Registration</h2>
        <p class="instruction-text">Create a new account for resort staff members.</p>

        <c:if test="${not empty error}">
            <div class="error-message" style="color: red; margin-bottom: 15px;">${error}</div>
        </c:if>

        <form action="add-user" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" required>

            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required>

            <label for="role">User Role:</label>
            <select name="role" style="width: 100%; padding: 12px; margin-bottom: 20px; border-radius: 5px; border: 1px solid #ccc;">
                <option value="Receptionist">Receptionist (Standard Access)</option>
                <option value="Admin">Admin (Full Access)</option>
            </select>

            <button type="submit">Register User</button>
        </form>

        <div style="margin-top: 20px;">
            <a href="dashboard.jsp" style="color: #007bff; text-decoration: none;">&larr; Back to Dashboard</a>
        </div>
    </div>
</body>
</html>