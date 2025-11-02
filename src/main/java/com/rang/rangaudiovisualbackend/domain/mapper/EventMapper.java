package com.rang.rangaudiovisualbackend.domain.mapper;

import com.rang.rangaudiovisualbackend.domain.dto.EventDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Event;

public interface EventMapper {
    EventDTO toDTO(Event event);
    Event fromDTO(EventDTO eventDTO);
}
