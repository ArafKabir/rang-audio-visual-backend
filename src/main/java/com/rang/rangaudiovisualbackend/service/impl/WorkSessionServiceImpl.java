package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;
import com.rang.rangaudiovisualbackend.domain.mapper.WorkSessionMapper;
import com.rang.rangaudiovisualbackend.repository.EventEmployeeRepository;
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

    @Override
    public WorkSessionDTO createSession(Long eventEmployeeId, WorkSessionDTO sessionDTO) {

        EventEmployee eventEmployee = eventEmployeeRepository.findById(eventEmployeeId)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));

        WorkSession workSession = workSessionMapper.fromDTO(sessionDTO);
        workSession.setEventEmployee(eventEmployee);

        WorkSession savedSession = workSessionRepository.save(workSession);
        return workSessionMapper.toDTO(savedSession);
    }

    @Override
    public WorkSessionDTO updateSession(Long sessionId, WorkSessionDTO updatedSessionDTO) {

        WorkSession session = workSessionRepository.findById(sessionId)
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
        if (!workSessionRepository.existsById(sessionId)) {
            throw new IllegalArgumentException("Session not found");
        }
        workSessionRepository.deleteById(sessionId);
    }

    @Override
    public List<WorkSessionDTO> getAllSessionsByEventEmployee(Long eventEmployeeId) {

        EventEmployee eventEmployee = eventEmployeeRepository.findById(eventEmployeeId)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));

        return workSessionRepository.findAllByEventEmployee(eventEmployee)
                .stream()
                .map(workSessionMapper::toDTO)
                .toList();
    }

    @Override
    public double getTotalHoursForEventEmployee(Long eventEmployeeId) {

        EventEmployee eventEmployee = eventEmployeeRepository.findById(eventEmployeeId)
                .orElseThrow(() -> new IllegalArgumentException("EventEmployee not found"));

        List<WorkSession> sessions = workSessionRepository.findAllByEventEmployee(eventEmployee);
        return sessions.stream()
                .mapToDouble(WorkSession::getDurationInHours)
                .sum();
    }
}
