package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.entity.Event;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.mapper.EventEmployeeMapper;
import com.rang.rangaudiovisualbackend.repository.EmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventEmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventRepository;
import com.rang.rangaudiovisualbackend.service.EventEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventEmployeeServiceImpl implements EventEmployeeService {
    private final EventRepository eventRepository;
    private final EmployeeRepository employeeRepository;
    private final EventEmployeeRepository eventEmployeeRepository;
    private final EventEmployeeMapper eventEmployeeMapper;

    @Override
    public EventEmployeeDTO addEmployeeToEvent(Long eventId, Long employeeId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        if (eventEmployeeRepository.existsByEventAndEmployee(event, employee)) {
            throw new IllegalArgumentException("Employee already assigned to this event");
        }

        EventEmployee eventEmployee = new EventEmployee();
        eventEmployee.setEvent(event);
        eventEmployee.setEmployee(employee);

        EventEmployee saved = eventEmployeeRepository.save(eventEmployee);

        return eventEmployeeMapper.toDTO(saved);
    }

    @Override
    public void removeEmployeeFromEvent(Long eventEmployeeId) {
        EventEmployee eventEmployee = eventEmployeeRepository.findById(eventEmployeeId)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));
        eventEmployeeRepository.delete(eventEmployee);
    }

    @Override
    public EventEmployeeDTO getEventEmployee(Long eventEmployeeId) {
        EventEmployee eventEmployee = eventEmployeeRepository.findById(eventEmployeeId)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));
        return eventEmployeeMapper.toDTO(eventEmployee);
    }

    @Override
    public List<EventEmployeeDTO> getAllByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        return eventEmployeeRepository.findAllByEvent(event)
                .stream()
                .map(eventEmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<EventEmployeeDTO> getAllByEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        return eventEmployeeRepository.findAllByEmployee(employee)
                .stream()
                .map(eventEmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public double calculateTotalHours(Long eventEmployeeId) {
        EventEmployee eventEmployee = eventEmployeeRepository.findById(eventEmployeeId)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));

        return eventEmployee.getTotalHoursWorked();
    }
}
