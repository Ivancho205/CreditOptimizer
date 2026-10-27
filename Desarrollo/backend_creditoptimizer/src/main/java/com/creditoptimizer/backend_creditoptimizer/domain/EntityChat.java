package com.creditoptimizer.backend_creditoptimizer.domain;

public record EntityChat (
    int id,
    String title,
    String type_chat,
    EntityUser user
){}

