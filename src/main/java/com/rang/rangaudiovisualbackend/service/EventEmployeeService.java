package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;

import java.util.List;

public interface EventEmployeeService {
    EventEmployeeDTO addEmployeeToEvent(Long eventId, Long employeeId);
    void removeEmployeeFromEvent(Long eventEmployeeId);

    EventEmployeeDTO getEventEmployee(Long eventEmployeeId);
    List<EventEmployeeDTO> getAllByEvent(Long eventId);
    List<EventEmployeeDTO> getAllByEmployee(Long employeeId);

    double calculateTotalHours(Long eventEmployeeId);
}
