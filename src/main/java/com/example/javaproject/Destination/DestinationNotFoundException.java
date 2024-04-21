package com.example.javaproject.Destination;

public class DestinationNotFoundException extends Exception {
    public DestinationNotFoundException(String message) {
        super(message);
    }

    public DestinationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
