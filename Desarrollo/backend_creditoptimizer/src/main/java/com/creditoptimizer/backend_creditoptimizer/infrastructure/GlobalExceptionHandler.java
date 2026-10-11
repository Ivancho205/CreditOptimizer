package com.creditoptimizer.backend_creditoptimizer.infrastructure;
import org.springframework.http.HttpStatus;
import java.time.Instant;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.creditoptimizer.backend_creditoptimizer.domain.EntityError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EntityError handleNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
        return new EntityError(
                "Resource Not Found",
                404,
                ex.getMessage(),
                req.getRequestURI(),
                Instant.now()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EntityError handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .findFirst()
                .orElse("Invalid input");

        return new EntityError(
                "Validation Error",
                400,
                message,
                req.getRequestURI(),
                Instant.now()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public EntityError handleGeneric(Exception ex, HttpServletRequest req) {
        return new EntityError(
                "Internal Server Error",
                500,
                "An unexpected error occurred",
                req.getRequestURI(),
                Instant.now()
        );
    }
}
