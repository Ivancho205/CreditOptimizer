package com.creditoptimizer.backend_creditoptimizer.domain;

public record EntityTransaction (
    int id,
    String name,
    String description,
    String category,
    double price,
    int quantity,
    boolean state
){}
