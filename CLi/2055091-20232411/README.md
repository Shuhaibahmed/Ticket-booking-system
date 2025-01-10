# Multithreaded Ticketing System

## Project Overview
The **Multithreaded Ticketing System** simulates a ticketing operation where vendors release tickets, and customers purchase them. This project demonstrates the use of multithreading to manage concurrent operations while ensuring thread safety and system scalability.

## Features
- **Configurable Settings**: Allows customization of ticket capacity, release rate, retrieval rate, and participant numbers.
- **Thread-safe Operations**: Utilizes synchronized methods to prevent race conditions.
- **Detailed Ticket Summary**: Provides real-time insights into tickets sold and remaining.
- **Graceful Thread Management**: Threads can be started and stopped safely without data loss.
- **Extensible Architecture**: Easy to add future enhancements like dynamic pricing or analytics.

---

## How It Works

### 1. Configuration
The system is initialized using the `Configuration` class:
- Users input:
  - Maximum ticket capacity
  - Total tickets available
  - Ticket release rate (seconds)
  - Customer retrieval rate (seconds)
  - Number of vendors
  - Number of customers
- Input validation ensures:
  - Positive values for all parameters.
  - Total tickets do not exceed the maximum capacity.
- Configuration details are saved to a file: `ticket_system_configuration.txt`.

### 2. Core Operations
Run the `Main` class to start the system. A menu provides the following options:
1. **Start Ticketing Operations**:
   - Vendors release tickets into a shared pool at a specified rate.
   - Customers retrieve tickets based on their retrieval rate.
   - Console logs display real-time ticket transactions.
2. **Stop Ticketing Operations**:
   - Gracefully interrupts all active threads.
3. **View Ticket Summary**:
   - Displays:
     - Tickets currently in the pool
     - Total tickets sold
4. **Exit**:
   - Stops all operations and exits the program.

### 3. Thread Management
- **Vendors**:
  - Add tickets to the pool until their allocated quota is complete.
  - Pause if the pool reaches maximum capacity.
- **Customers**:
  - Retrieve tickets from the pool until their allocated quota is met.
  - Wait if no tickets are available.
- **Synchronization**:
  - Prevents race conditions during ticket addition and retrieval.

---

## Classes Overview

### 1. `Configuration`
Handles system initialization and input validation.

### 2. `Ticket`
Represents a ticket with attributes such as ID and price.

### 3. `TicketPool`
Manages the shared pool of tickets with synchronized methods for adding and retrieving tickets.

### 4. `Vendor`
Runs as a thread to release tickets into the pool at a defined rate.

### 5. `Customer`
Runs as a thread to purchase tickets from the pool at a defined rate.

### 6. `ThreadManager`
Handles the creation, management, and graceful interruption of vendor and customer threads.

### 7. `Main`
The entry point of the program with a user menu for interaction.

---

## Running the Project

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or above.
- A Java IDE or command-line setup.

### Steps to Run
1. Clone or download the project repository.
2. Open the project in your preferred IDE or compile it using the command line.
3. Run the `Main` class to start the program.
4. Follow the on-screen instructions to configure and operate the ticketing system.

---

## Future Enhancements
- **Dynamic Pricing**: Adjust ticket prices based on demand.
- **Advanced Analytics**: Provide insights like peak ticket demand times.
- **Graphical User Interface (GUI)**: Replace the console-based interface with a user-friendly GUI.
- **Event-specific Features**: Add support for multiple events and ticket types.

---

## Conclusion
The **Multithreaded Ticketing System** demonstrates how to handle concurrent operations effectively using Java threads. It is a practical example of solving real-world problems like ticketing and resource allocation while ensuring scalability and thread safety.

---

## License
This project is licensed under the MIT License.

---

## Author
Developed by Shuhaib Ahamed.
