package com.rang.rangaudiovisualbackend.domain.mapper.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.dto.EventDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Event;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.mapper.EmployeeMapper;
import com.rang.rangaudiovisualbackend.domain.mapper.EventMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapperImpl implements EventMapper {

    private final EmployeeMapper employeeMapper;

    public EventMapperImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }
    @Override
    public EventDTO toDTO(Event event) {

        List<EmployeeDTO> eventEmployees = event.getEventEmployees().stream()
                .map(EventEmployee::getEmployee).map(employeeMapper::toDTO).collect(Collectors.toList());

        return new EventDTO(
                event.getId(),
                event.getName(),
                event.getDate(),
                event.getLocation(),
                eventEmployees
        );
    }

    @Override
    public Event fromDTO(EventDTO eventDTO) {

        Event event = new Event();
        event.setId(eventDTO.id());
        event.setName(eventDTO.name());
        event.setDate(eventDTO.date());
        event.setLocation(eventDTO.location());
        return event;
    }
}
