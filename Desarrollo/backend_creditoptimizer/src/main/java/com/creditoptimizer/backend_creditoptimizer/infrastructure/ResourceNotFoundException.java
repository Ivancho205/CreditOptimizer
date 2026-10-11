package com.creditoptimizer.backend_creditoptimizer.infrastructure;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
