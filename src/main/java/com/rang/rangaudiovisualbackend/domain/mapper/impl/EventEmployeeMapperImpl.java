package com.rang.rangaudiovisualbackend.domain.mapper.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.mapper.EventEmployeeMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventEmployeeMapperImpl implements EventEmployeeMapper {

    @Override
    public EventEmployeeDTO toDTO(EventEmployee eventEmployee) {
        if (eventEmployee == null) return null;


        List<WorkSessionDTO> workSessions = eventEmployee.getWorkSessions() != null
                ? eventEmployee.getWorkSessions().stream()
                .map(ws -> new WorkSessionDTO(
                        ws.getId(),
                        ws.getStartTime(),
                        ws.getEndTime(),
                        ws.getDurationInHours()))
                .collect(Collectors.toList())
                : List.of();


        return new EventEmployeeDTO(
                eventEmployee.getId(),
                eventEmployee.getEvent() != null ? eventEmployee.getEvent().getId() : null,
                eventEmployee.getEmployee() != null ? eventEmployee.getEmployee().getId() : null,
                eventEmployee.getEmployee() != null
                        ? eventEmployee.getEmployee().getFirstName() + " " + eventEmployee.getEmployee().getLastName()
                        : null,
                eventEmployee.getTotalHoursWorked(),
                workSessions
        );
    }

    @Override
    public EventEmployee fromDTO(EventEmployeeDTO dto) {
        // Typically not used for now, can implement later if needed
        return null;
    }
}
