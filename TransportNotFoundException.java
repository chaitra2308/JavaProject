package com.example.javaproject.Transport;

public class TransportNotFoundException extends RuntimeException {
    public TransportNotFoundException(String message) {
        super(message);
    }
}
