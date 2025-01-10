package com.example.demo.exception;

public class TicketNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TicketNotFoundException(String message) {
        super(message);
    }

    public TicketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
