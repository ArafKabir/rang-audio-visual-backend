package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EventDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Event;
import com.rang.rangaudiovisualbackend.domain.mapper.EventMapper;
import com.rang.rangaudiovisualbackend.repository.EmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventEmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventRepository;
import com.rang.rangaudiovisualbackend.service.EventService;

import java.util.List;

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

    }

    @Override
    public EventDTO getEventById(Long eventId) {
        return null;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return List.of();
    }

    @Override
    public EventDTO assignEmployeeToEvent(Long eventId, Long employeeId) {
        return null;
    }

    @Override
    public EventDTO removeEmployeeFromEvent(Long eventId, Long employeeId) {
        return null;
    }
}
