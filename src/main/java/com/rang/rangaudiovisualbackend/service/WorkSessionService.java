package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;

import java.util.List;

public interface WorkSessionService {
    WorkSessionDTO createSession(Long eventEmployeeId, WorkSessionDTO sessionDTO);
    WorkSessionDTO updateSession(Long sessionId, WorkSessionDTO updatedSessionDTO);
    void deleteSession(Long sessionId);

    List<WorkSessionDTO> getAllSessionsByEventEmployee(Long eventEmployeeId);
    double getTotalHoursForEventEmployee(Long eventEmployeeId);
}
