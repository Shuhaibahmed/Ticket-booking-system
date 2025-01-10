package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.TicketCapacityExceededException;
import com.example.demo.exception.TicketNotFoundException;
import com.example.demo.model.Ticket;

public interface TicketService {
    Ticket addTicket(Ticket ticket) throws TicketCapacityExceededException;
    void removeTicket(Long id) throws TicketNotFoundException;
    List<Ticket> getAllTickets();
}