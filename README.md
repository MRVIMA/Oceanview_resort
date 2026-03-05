<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>README - Ocean View Resort</title>
</head>
<body>

    <h1>Ocean View Resort - Reservation Management System 🌊🏨</h1>

    <p>
        A distributed web application developed to modernize the manual room reservation and guest record management at 
        <strong>Ocean View Resort, Galle</strong>. This system implements a robust 3-tier MVC architecture to eliminate 
        booking conflicts and automate financial calculations.
    </p>

    <hr>

    <h2>🚀 Core Functionalities (Scenario Requirements)</h2>
    <ul>
        <li><strong>User Authentication:</strong> Secure login system for Admins and Receptionists.</li>
        <li><strong>New Reservation:</strong> Comprehensive guest registration and booking details storage.</li>
        <li><strong>Display Details:</strong> Retrieval and display of specific booking information.</li>
        <li><strong>Billing Engine:</strong> Automated computation of total stay costs based on nights and room rates.</li>
        <li><strong>Help Section:</strong> Interactive guidelines for new staff members.</li>
        <li><strong>Exit System:</strong> Secure session invalidation and logout.</li>
    </ul>

    <hr>

    <h2>🏗️ Architectural Design</h2>
    <p>
        The system follows the <strong>Model-View-Controller (MVC)</strong> design pattern to ensure high maintainability 
        and separation of concerns.
    </p>
    <ul>
        <li><strong>Presentation Layer:</strong> JSP, CSS, and JSTL for a responsive, sophisticated UI.</li>
        <li><strong>Business Logic Layer:</strong> Java Servlets managing the request-response lifecycle.</li>
        <li><strong>Data Access Layer:</strong> DAO pattern for decoupled MySQL database interactions.</li>
    </ul>

    

    <hr>

    <h2>🧪 Quality Assurance & TDD</h2>
    <p>
        I utilized <strong>Test-Driven Development (TDD)</strong> with the <strong>Red-Green-Refactor</strong> 
        lifecycle to ensure the reliability of the billing and reservation modules.
    </p>
    <ul>
        <li><strong>Automation:</strong> JUnit 5 test suites for the <code>ReservationService</code>.</li>
        <li><strong>Validation:</strong> MySQL Triggers for chronological date constraints.</li>
        <li><strong>Traceability:</strong> All managerial requirements are mapped to specific test cases.</li>
    </ul>

    

    <hr>

    <h2>🛠️ Installation & Setup</h2>
    <ol>
        <li>Clone the repository: <code>git clone https://github.com/VimaIroshan/OceanViewResort.git</code></li>
        <li>Import the project into <strong>Eclipse IDE</strong> as a Dynamic Web Project.</li>
        <li>Create a MySQL database named <code>oceanview_db</code> and run the provided SQL scripts.</li>
        <li>Configure <code>DatabaseUtil.java</code> with your local MySQL credentials.</li>
        <li>Deploy the application on <strong>Apache Tomcat 9.0+</strong>.</li>
    </ol>

    <hr>

    <hr>

    <h2>👤 Author</h2>
    <p>
        <strong>Vimukthi Iroshan Mahanama Hewage</strong><br>
        BSc (Hons) in Software Engineering<br>
        Cardiff Metropolitan University | Student ID: st20286419
    </p>

</body>
</html>