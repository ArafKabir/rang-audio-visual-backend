package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.service.EventEmployeeService;

import java.util.List;

public class EventEmployeeServiceImpl implements EventEmployeeService {
    @Override
    public EventEmployeeDTO addEmployeeToEvent(Long eventId, Long employeeId) {
        return null;
    }

    @Override
    public void removeEmployeeFromEvent(Long eventEmployeeId) {

    }

    @Override
    public EventEmployeeDTO getEventEmployee(Long eventEmployeeId) {
        return null;
    }

    @Override
    public List<EventEmployeeDTO> getAllByEvent(Long eventId) {
        return List.of();
    }

    @Override
    public List<EventEmployeeDTO> getAllByEmployee(Long employeeId) {
        return List.of();
    }

    @Override
    public double calculateTotalHours(Long eventEmployeeId) {
        return 0;
    }
}
