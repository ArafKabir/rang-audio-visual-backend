package com.rang.rangaudiovisualbackend.domain.mapper.impl;

import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;
import com.rang.rangaudiovisualbackend.domain.mapper.WorkSessionMapper;

public class WorkSessionMapperImpl implements WorkSessionMapper {
    @Override
    public WorkSessionDTO toDTO(WorkSession workSession) {
        return new WorkSessionDTO(
                workSession.getId(),
                workSession.getStartTime(),
                workSession.getEndTime(),
                workSession.getDurationInHours()
        );
    }

    @Override
    public WorkSession fromDTO(WorkSessionDTO workSessionDTO) {
        WorkSession workSession = new WorkSession();
        workSession.setId(workSessionDTO.id());
        workSession.setStartTime(workSessionDTO.startTime());
        workSession.setEndTime(workSessionDTO.endTime());

        return workSession;
    }
}
