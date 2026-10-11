package com.creditoptimizer.backend_creditoptimizer.infrastructure;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}