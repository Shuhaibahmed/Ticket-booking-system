package com.example.demo.entity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

public class VendorThread implements Runnable {

    private final TicketService ticketService;
    private final int operationsCount;
    private final Random random = new Random();
    private volatile boolean isRunning = true;

    public VendorThread(TicketService ticketService, int operationsCount) {
        if (ticketService == null) {
            throw new IllegalArgumentException("TicketService cannot be null");
        }
        if (operationsCount <= 0) {
            throw new IllegalArgumentException("Operations count must be positive");
        }
        this.ticketService = ticketService;
        this.operationsCount = operationsCount;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        int completedOperations = 0;
        while (isRunning && completedOperations < operationsCount) {
            Ticket ticket = new Ticket();
            try {
                ticket.setEventName("Event " + completedOperations);
                // Set price between 10 and 110
                ticket.setPrice(10 + random.nextDouble() * 100);
                ticketService.addTicket(ticket);
                completedOperations++;
                
                // Use TimeUnit for more readable sleep duration
                TimeUnit.MILLISECONDS.sleep(random.nextInt(90) + 10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;  // Exit the loop on interruption
            } catch (Exception e) {
                System.err.println("Error adding ticket: " + e.getMessage());
                // Add small delay before retry
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
