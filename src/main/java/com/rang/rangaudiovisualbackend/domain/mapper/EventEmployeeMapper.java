package com.rang.rangaudiovisualbackend.domain.mapper;

import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;

public interface EventEmployeeMapper {
    EventEmployeeDTO toDTO(EventEmployee eventEmployee);
    Employee fromDTO(EventEmployeeDTO eventEmployeeDTO);
}
