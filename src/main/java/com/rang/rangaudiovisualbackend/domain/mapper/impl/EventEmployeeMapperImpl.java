package com.rang.rangaudiovisualbackend.domain.mapper.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.mapper.EventEmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EventEmployeeMapperImpl implements EventEmployeeMapper {

    @Override
    public EventEmployeeDTO toDTO(EventEmployee eventEmployee) {
        return null;
    }

    @Override
    public Employee fromDTO(EventEmployeeDTO employeeDTO) {
        return null;
    }
}
