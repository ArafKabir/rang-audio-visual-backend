package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;

import java.util.List;

public interface WorkSessionService {
    WorkSessionDTO createSession(Long eventId, Long employeeId, WorkSessionDTO workSessionDTO);
    WorkSessionDTO updateSession(WorkSessionDTO updatedSessionDTO);
    void deleteSession(Long sessionId);

    List<WorkSessionDTO> getAllSessionsByEventEmployee(Long eventId, Long employeeId);
}
