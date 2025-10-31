package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;

import java.util.List;

public interface WorkSessionService {
    public List<WorkSession> addWorkSessions();
    public List<WorkSession> getSessionsByEventEmployee();
}
