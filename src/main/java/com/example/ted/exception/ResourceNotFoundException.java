package com.example.ted.exception;

import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id, String message) {
        super(message + " - ID: " + id);
    }
}
