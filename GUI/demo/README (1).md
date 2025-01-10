# Ticket Management System

## Overview
This is a backend application for managing event tickets. It provides APIs to add, remove, and list tickets. The application is built using Spring Boot and connects to a MySQL database for persistent storage.

## Features
- **Add Tickets**: Create new event tickets with details like event name and price.
- **Remove Tickets**: Delete tickets by ID.
- **List Tickets**: Retrieve all available tickets.
- **Thread-Safe Ticket Operations**: Vendor and customer threads simulate ticket creation and deletion concurrently.

## Prerequisites
- **Java Development Kit (JDK)**: Version 11 or higher.
- **Apache Maven**: Version 3.6 or higher.
- **MySQL Database**: Installed and running.
- **Postman or cURL** (optional): For API testing.

## Setup Instructions

### 1. Clone the Repository
```bash
$ git clone <repository-url>
$ cd <repository-folder>
```

### 2. Configure the Database
Ensure MySQL is running and create a database named `myapp`. Update the `application.properties` file with your database credentials:

```
spring.datasource.url=jdbc:mysql://localhost:3306/myapp
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
ticket.pool.max-capacity=100
```

### 3. Build and Run the Application

#### Using Maven
```bash
$ mvn clean install
$ mvn spring-boot:run
```

The application will start at `http://localhost:8080`.

### 4. API Endpoints

#### Base URL: `http://localhost:8080/api/tickets`

- **POST /api/tickets**
  - Add a new ticket.
  - Request Body:
    ```json
    {
      "eventName": "Concert",
      "price": 50.0
    }
    ```
  - Response:
    ```json
    {
      "id": 1,
      "eventName": "Concert",
      "price": 50.0
    }
    ```

- **DELETE /api/tickets/{id}**
  - Remove a ticket by ID.
  - Response: HTTP 204 No Content

- **GET /api/tickets**
  - Retrieve all tickets.
  - Response:
    ```json
    [
      {
        "id": 1,
        "eventName": "Concert",
        "price": 50.0
      }
    ]
    ```

### 5. Multi-Threading Operations
The system simulates ticket creation and deletion through two types of threads:
- **VendorThread**: Adds tickets with random event names and prices.
- **CustomerThread**: Removes random tickets if available.

These threads demonstrate concurrent operations on the ticket pool.

## Project Structure
```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/         # REST controllers
│   │   ├── entity/             # Thread operations and ticket pool
│   │   ├── exception/          # Custom exceptions
│   │   ├── model/              # JPA entities
│   │   ├── repository/         # Spring Data repositories
│   │   ├── service/            # Service layer
│   │   └── EventApplication.java  # Main application class
│   └── resources/
│       ├── application.properties  # Configuration file
│       └── data.sql                # Sample data (optional)
└── test/                           # Unit and integration tests
```

## Key Components

### 1. `TicketController`
Handles incoming HTTP requests for ticket operations.

### 2. `TicketPool`
A thread-safe ticket storage implemented with `ConcurrentLinkedDeque`.

### 3. `VendorThread` and `CustomerThread`
Simulates adding and removing tickets in a multi-threaded environment.

### 4. Exception Handling
- `TicketCapacityExceededException`: Raised when the ticket pool exceeds its maximum capacity.
- `TicketNotFoundException`: Raised when a ticket with the given ID is not found.

## Notes
- Ensure the database is running before starting the application.
- Modify the maximum ticket pool size in `application.properties` as needed.

## Running Tests
To run unit tests, execute:
```bash
$ mvn test
```

## Author
Developed by Shuhaib.

## License
This project is licensed under the MIT License.

