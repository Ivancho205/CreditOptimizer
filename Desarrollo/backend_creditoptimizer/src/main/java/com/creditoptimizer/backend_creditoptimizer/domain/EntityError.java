package com.creditoptimizer.backend_creditoptimizer.domain;

import java.time.Instant;

public record EntityError(
        String title,
        int status,
        String detail,
        String path,
        Instant timestamp
) {}