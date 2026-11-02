package com.creditoptimizer.backend_creditoptimizer.domain;

public record EntityUser (
    int id,
    String name,
    String email,
    String user_type,
    String password
){}

