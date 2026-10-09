package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.entity.Event;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;
import com.rang.rangaudiovisualbackend.domain.mapper.WorkSessionMapper;
import com.rang.rangaudiovisualbackend.repository.EmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventEmployeeRepository;
import com.rang.rangaudiovisualbackend.repository.EventRepository;
import com.rang.rangaudiovisualbackend.repository.WorkSessionRepository;
import com.rang.rangaudiovisualbackend.service.WorkSessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkSessionServiceImpl implements WorkSessionService {
    private WorkSessionRepository workSessionRepository;
    private EventEmployeeRepository eventEmployeeRepository;
    private WorkSessionMapper workSessionMapper;
    private EventRepository eventRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public WorkSessionDTO createSession(Long eventId, Long employeeId, WorkSessionDTO workSessionDTO) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        EventEmployee eventEmployee = eventEmployeeRepository.findByEventAndEmployee(event, employee)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));

        WorkSession workSession = workSessionMapper.fromDTO(workSessionDTO);
        workSession.setEventEmployee(eventEmployee);

        WorkSession savedSession = workSessionRepository.save(workSession);
        return workSessionMapper.toDTO(savedSession);
    }

    @Override
    public WorkSessionDTO updateSession(WorkSessionDTO updatedSessionDTO) {

        WorkSession session = workSessionRepository.findById(updatedSessionDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Session not found"));

        if (updatedSessionDTO.startTime() != null)
            session.setStartTime(updatedSessionDTO.startTime());
        if (updatedSessionDTO.endTime() != null)
            session.setEndTime(updatedSessionDTO.endTime());

        WorkSession updatedSession = workSessionRepository.save(session);
        return workSessionMapper.toDTO(updatedSession);
    }

    @Override
    public void deleteSession(Long sessionId) {
       WorkSession workSession = workSessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session not found"));

       workSessionRepository.delete(workSession);
    }

    @Override
    public List<WorkSessionDTO> getAllSessionsByEventEmployee(Long eventId, Long employeeId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        EventEmployee eventEmployee = eventEmployeeRepository.findByEventAndEmployee(event, employee)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));

        return workSessionRepository.findAllByEventEmployee(eventEmployee)
                .stream()
                .map(workSessionMapper::toDTO)
                .toList();
    }

}
