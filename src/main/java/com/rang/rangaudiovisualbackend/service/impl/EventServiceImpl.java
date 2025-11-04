package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EventDTO;
import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.entity.Event;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.mapper.EventMapper;
import com.rang.rangaudiovisualbackend.repository.EmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventEmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventRepository;
import com.rang.rangaudiovisualbackend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EmployeeRepository employeeRepository;
    private final EventEmployeeRepository eventEmployeeRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event savedEvent = eventRepository.save(eventMapper.fromDTO(eventDTO));

        return eventMapper.toDTO(savedEvent);
    }

    @Override
    public EventDTO updateEvent(Long eventId, EventDTO updatedEventDTO) {
        return null;
    }

    @Override
    public void deleteEvent(Long eventId) {
        if(!eventRepository.existsById(eventId)) {
            throw new IllegalArgumentException("Event not found");
        }

        eventRepository.deleteById(eventId);
    }

    @Override
    public EventDTO getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        return eventMapper.toDTO(event);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO assignEmployeeToEvent(Long eventId, Long employeeId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        if (eventEmployeeRepository.existsByEventAndEmployee(event, employee)) {
            throw new IllegalArgumentException("Employee already assigned to event");
        }

        EventEmployee eventEmployee = new EventEmployee();
        eventEmployee.setEvent(event);
        eventEmployee.setEmployee(employee);
        eventEmployeeRepository.save(eventEmployee);

        event.getEventEmployees().add(eventEmployee);
        eventRepository.save(event);

        Event updatedEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Error updating event"));

        return eventMapper.toDTO(updatedEvent);
    }

    @Override
    public EventDTO removeEmployeeFromEvent(Long eventId, Long employeeId) {
        return null;
    }
}
