package com.example.demo.entity;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.exception.TicketCapacityExceededException;
import com.example.demo.model.Ticket;

@Component
public class TicketPool {
    private final ConcurrentLinkedDeque<Ticket> tickets = new ConcurrentLinkedDeque<>();

    @Value("${ticket.pool.max-capacity:1000}") // Added default value
    private int maxCapacity;

    // Add a ticket to the pool, throws exception if max capacity is reached
    public synchronized void addTicket(Ticket ticket) throws TicketCapacityExceededException {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }

        if (tickets.size() >= maxCapacity) {
            throw new TicketCapacityExceededException("Ticket pool is at maximum capacity");
        }

        tickets.offer(ticket);
    }

    // Remove a ticket from the pool
    public synchronized boolean removeTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }
        return tickets.remove(ticket);
    }

    // Get the current size of the ticket pool
    public int getSize() {
        return tickets.size();
    }
}
