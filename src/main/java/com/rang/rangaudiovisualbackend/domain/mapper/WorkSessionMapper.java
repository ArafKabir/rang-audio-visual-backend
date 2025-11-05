package com.rang.rangaudiovisualbackend.domain.mapper;

import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;

import java.util.List;

public interface WorkSessionMapper {
    public WorkSessionDTO toDTO(WorkSession workSession);
    public WorkSession fromDTO(WorkSessionDTO workSessionDTO);
}
