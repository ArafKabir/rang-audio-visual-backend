package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.dto.EventDTO;

import java.util.List;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);
    EventDTO updateEvent(Long eventId, EventDTO updatedEventDTO);
    void deleteEvent(Long eventId);

    EventDTO getEventById(Long eventId);
    List<EventDTO> getAllEvents();

    // Relations
    EventDTO assignEmployeeToEvent(Long eventId, Long employeeId);
    EventDTO removeEmployeeFromEvent(Long eventId, Long employeeId);
}
