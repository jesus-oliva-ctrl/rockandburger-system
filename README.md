## 🍔 About the Project

**Rock & Burger System** is a lightweight, local-first Point of Sale (POS) and Inventory Management desktop application. Designed specifically as a software engineering portfolio piece, this project demonstrates the practical application of Object-Oriented Programming (OOP) principles, relational database management, and clean architectural patterns.

The system is split into two main modules based on Role-Based Access Control (RBAC):
* **Cashier Module (POS):** A fast, touch-friendly interface for order processing, quick catalog search, and cash register management.
* **Admin Module (Inventory):** A robust management dashboard featuring a compound inventory deduction system (recipes), manual shrinkage adjustments, and soft-delete capabilities.

### 🛠️ Tech Stack & Architecture

* **Language:** Java 17 LTS
* **Architecture:** MVC (Model-View-Controller) pattern following Maven's Standard Directory Layout.
* **GUI Framework:** JavaFX designed with Gluon Scene Builder.
* **Database & ORM:** SQLite embedded database managed via Hibernate Core ORM.
* **Build Tool:** Apache Maven.
* **Testing & Quality:** JUnit 5 for unit testing and SLF4J + Logback for silent error logging.