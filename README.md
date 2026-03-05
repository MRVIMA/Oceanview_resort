# Ocean View Resort - Reservation Management System 🌊🏨

<p align="center">
  <img src="https://komarev.com/ghpvc/?username=VimaIroshan&label=PROJECT%20VIEWS&color=0077b5&style=flat-square" alt="Views">
</p>

<p align="center">
  <a href="https://www.oracle.com/java/">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java">
  </a>
  <a href="https://www.mysql.com/">
    <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  </a>
  <a href="https://tomcat.apache.org/">
    <img src="https://img.shields.io/badge/Apache_Tomcat-F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black" alt="Tomcat">
  </a>
</p>


---

A distributed web application developed to modernize the manual room reservation and guest record management at **Ocean View Resort, Galle**. This system implements a robust 3-tier MVC architecture to eliminate booking conflicts and automate financial calculations.

---

## 🚀 Core Functionalities (Scenario Requirements)

- **User Authentication:** Secure login system with role-based access for Admins and Receptionists.
- **New Reservation:** Comprehensive guest registration and secure booking detail storage.
- **Display Details:** Efficient retrieval and display of specific booking information via unique reservation numbers.
- **Billing Engine:** Automated computation of total stay costs based on nights and specific room rates.
- **Help Section:** Integrated interactive guidelines for new staff members.
- **Exit System:** Secure session invalidation and logout functionality.

---

## 🏗️ Architectural Design

The system follows the **Model-View-Controller (MVC)** design pattern to ensure high maintainability, scalability, and separation of concerns.

- **Presentation Layer:** Developed using **JSP, CSS, and JSTL** for a responsive and sophisticated UI.
- **Business Logic Layer:** **Java Servlets** managing the request-response lifecycle and session handling.
- **Data Access Layer:** **DAO Pattern** implemented for decoupled and secure MySQL database interactions.



---

## 🧪 Quality Assurance & TDD

I utilized **Test-Driven Development (TDD)** following the **Red-Green-Refactor** lifecycle to ensure the total reliability of the billing and reservation modules.

- **Automation:** **JUnit 5** automated test suites specifically for the `ReservationService` logic.
- **Validation:** Advanced **MySQL Triggers** implemented for chronological date constraints (Check-out > Check-in).
- **Traceability:** A detailed Traceability Matrix ensures all managerial requirements are mapped to specific, passing test cases.



---

## 🛠️ Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/VimaIroshan/OceanViewResort.git](https://github.com/VimaIroshan/OceanViewResort.git)


---

## 🎓 Academic Profile

| Attribute | Details |
| :--- | :--- |
| **Author** | **Vimukthi Iroshan Mahanama Hewage** |
| **Program** | BSc (Hons) in Software Engineering |
| **Institution** | Cardiff Metropolitan University |
| **Student ID** | `st20286419` |
| **Project** | Ocean View Resort Management System |
| **Module** | Distributed Web Applications |

---
