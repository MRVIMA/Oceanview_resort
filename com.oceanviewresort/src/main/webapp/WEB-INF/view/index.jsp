<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Menu - Ocean View Resort</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        .menu-item {
            margin: 15px 0;
            padding: 15px;
            background-color: #e6f7ff;
            border-radius: 5px;
            text-align: center;
        }
        .menu-item a {
            color: #007bff;
            text-decoration: none;
            font-size: 18px;
            display: block;
        }
        .menu-item a:hover {
            text-decoration: underline;
        }
        .logout-btn {
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
        }
        .logout-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Welcome to Ocean View Resort Reservation System</h2>

    <div class="menu-item">
        <a href="add-reservation">Add New Reservation</a>
    </div>

    <div class="menu-item">
        <a href="display-reservation">Display Reservation Details</a>
    </div>

    <div class="menu-item">
        <a href="calculate-bill">Calculate Bill</a>
    </div>

    <div class="menu-item">
        <a href="help">Help Section</a>
    </div>

    <form action="logout" method="post">
        <button type="submit" class="logout-btn">Logout</button>
    </form>
</div>
</body>
</html>
