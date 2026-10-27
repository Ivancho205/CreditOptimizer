package com.creditoptimizer.backend_creditoptimizer.domain;

import java.sql.Date;

public record EntitySuggestion (
    int id,
    Date expiration_date,
    String agent_answer,
    EntityUser user,
    EntityChat chat 
){}

