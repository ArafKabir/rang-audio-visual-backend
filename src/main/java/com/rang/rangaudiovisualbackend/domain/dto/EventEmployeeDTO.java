package com.rang.rangaudiovisualbackend.domain.dto;

import java.util.List;

public record EventEmployeeDTO(
        Long id,
        Long eventId,
        Long employeeId,
        String employeeName,
        double totalHoursWorked,
        List<WorkSessionDTO> workSessions
) {}
