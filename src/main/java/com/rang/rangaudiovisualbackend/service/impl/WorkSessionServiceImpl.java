package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;
import com.rang.rangaudiovisualbackend.service.WorkSessionService;

import java.util.List;

public class WorkSessionServiceImpl implements WorkSessionService {

    @Override
    public WorkSessionDTO createSession(Long eventEmployeeId, WorkSessionDTO sessionDTO) {
        return null;
    }

    @Override
    public WorkSessionDTO updateSession(Long sessionId, WorkSessionDTO updatedSessionDTO) {
        return null;
    }

    @Override
    public void deleteSession(Long sessionId) {

    }

    @Override
    public List<WorkSessionDTO> getAllSessionsByEventEmployee(Long eventEmployeeId) {
        return List.of();
    }

    @Override
    public double getTotalHoursForEventEmployee(Long eventEmployeeId) {
        return 0;
    }
}
