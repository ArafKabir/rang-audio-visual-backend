package com.rang.rangaudiovisualbackend.domain.mapper;

import com.rang.rangaudiovisualbackend.domain.dto.EventEmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;

public interface EventEmployeeMapper {
    EventEmployeeDTO toDTO(Employee employee);
    Employee fromDTO(EventEmployeeDTO employeeDTO);
}
