package com.creditoptimizer.backend_creditoptimizer.infrastructure;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
