package com.creditoptimizer.backend_creditoptimizer.domain;

import java.time.LocalDate;

public record EntitySuggestion (
    int id,
    LocalDate expiration_date,
    String agent_answer,
    EntityChat chat 
){}

