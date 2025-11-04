package com.rang.rangaudiovisualbackend.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public record EventDTO (
        Long id,
        String name,
        LocalDateTime date,
        String location,
        List<EmployeeDTO> employees
)
{}
