package com.example.demo.exception;

public class TicketCapacityExceededException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TicketCapacityExceededException(String message) {
        super(message);
    }

    public TicketCapacityExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
