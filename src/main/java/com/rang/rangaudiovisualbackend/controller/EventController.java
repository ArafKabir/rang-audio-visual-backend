package com.rang.rangaudiovisualbackend.controller;

import com.rang.rangaudiovisualbackend.domain.dto.EventDTO;
import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;


    @PostMapping("/create")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventDTO createdEvent = eventService.createEvent(eventDTO);
        return ResponseEntity.ok(createdEvent);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long eventId) {
        try {
            EventDTO event = eventService.getEventById(eventId);
            return ResponseEntity.ok(event);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }


    @PutMapping("/update/{eventId}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long eventId, @RequestBody EventDTO eventDTO) {
        EventDTO updatedEvent = eventService.updateEvent(eventId, eventDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully.");
    }


    @PostMapping("/{eventId}/assign/{employeeId}")
    public ResponseEntity<EventDTO> assignEmployeeToEvent(@PathVariable Long eventId, @PathVariable Long employeeId) {
        EventDTO updatedEvent = eventService.assignEmployeeToEvent(eventId, employeeId);
        return ResponseEntity.ok(updatedEvent);
    }

    @GetMapping("/{eventId}/employees")
    public ResponseEntity<List<EventEmployeeDTO>> getEmployeesByEventId(@PathVariable Long eventId) {
        try {
            List<EventEmployeeDTO> employees = eventService.getEmployeesByEventId(eventId);
            return ResponseEntity.ok(employees);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{eventId}/remove/{employeeId}")
    public ResponseEntity<EventDTO> removeEmployeeFromEvent(@PathVariable Long eventId, @PathVariable Long employeeId) {
        EventDTO updatedEvent = eventService.removeEmployeeFromEvent(eventId, employeeId);
        return ResponseEntity.ok(updatedEvent);
    }


}
