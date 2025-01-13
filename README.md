
---

# Ticket Management System

## Overview

The **Ticket Management System** is a comprehensive solution for managing event tickets. It consists of a backend built with Spring Boot, a frontend developed using React and Tailwind CSS, and a multithreaded CLI for ticket simulations. The system supports operations such as adding, removing, and listing tickets, and demonstrates thread-safe handling of concurrent tasks.

---

## Features

- **Backend**:
  - Add, remove, and list tickets via REST APIs.
  - Multi-threaded ticket operations for vendors and customers.
  - Persistent storage using MySQL.
  
- **Frontend**:
  - User-friendly interface for managing tickets.
  - Developed using React and Tailwind CSS.
  
- **CLI**:
  - Simulates ticket release and purchase using Java threads.
  - Configurable ticketing parameters.
  - Real-time transaction logs and summaries.

---

## Prerequisites

- **Backend**:
  - JDK 11 or higher
  - Apache Maven 3.6+
  - MySQL database
  - Postman or cURL (optional for testing APIs)
  
- **Frontend**:
  - Node.js and npm/yarn installed
  
- **CLI**:
  - JDK 8 or higher

---

## Setup Instructions

### Backend

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd backend
   ```

2. Configure the database:
   - Create a MySQL database named `myapp`.
   - Update `application.properties` with your database credentials.

3. Build and run the backend:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   The backend will run on `http://localhost:8080`.

---

### Frontend

1. Navigate to the frontend folder:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Run the development server:
   ```bash
   npm start
   ```
   Access the frontend at `http://localhost:3000`.

---

### CLI

1. Compile and run the `Main` class:
   ```bash
   javac Main.java
   java Main
   ```

2. Follow the on-screen instructions to configure and operate the system.

---

## API Endpoints

**Base URL**: `http://localhost:8080/api/tickets`

- `POST /api/tickets`: Add a new ticket.
- `DELETE /api/tickets/{id}`: Remove a ticket by ID.
- `GET /api/tickets`: List all tickets.

---

## Project Structure

```
project-root/
├── backend/
│   ├── src/main/java/com/example/demo/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── service/
│   │   └── EventApplication.java
│   └── resources/
│       ├── application.properties
│       └── data.sql
├── frontend/
│   ├── public/
│   ├── src/
│   └── package.json
└── cli/
    ├── Configuration.java
    ├── Ticket.java
    ├── TicketPool.java
    ├── Vendor.java
    ├── Customer.java
    ├── ThreadManager.java
    └── Main.java
```

---

## License

This project is licensed under the MIT License.

---

## Author

Developed by Shuhaib Ahamed.
