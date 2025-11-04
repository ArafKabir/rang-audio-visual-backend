package com.rang.rangaudiovisualbackend.domain.dto;

import java.time.LocalDateTime;

public record WorkSessionDTO(
        Long id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        double durationInHours
) {}
