package com.example.demo.entity;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

public class CustomerThread extends Thread {

    private final TicketService ticketService;
    private final int operationsCount;
    private final Random random = new Random();
    private volatile boolean isRunning = true;

    public CustomerThread(TicketService ticketService, int operationsCount) {
        this.ticketService = ticketService;
        this.operationsCount = operationsCount;
    }

    public void requestStop() {
        isRunning = false;
    }

    @Override
    public void run() {
        int completedOperations = 0;
        while (isRunning && completedOperations < operationsCount) {
            try {
                List<Ticket> tickets = ticketService.getAllTickets();
                if (!tickets.isEmpty()) {
                    int randomIndex = random.nextInt(tickets.size());
                    Ticket selectedTicket = tickets.get(randomIndex);
                    if (selectedTicket != null) {
                        ticketService.removeTicket(selectedTicket.getId());
                        completedOperations++;
                    }
                }
                // Use TimeUnit for more readable sleep duration
                TimeUnit.MILLISECONDS.sleep(random.nextInt(90) + 10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;  // Exit the loop on interruption
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.err.println("Error processing ticket: " + e.getMessage());
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