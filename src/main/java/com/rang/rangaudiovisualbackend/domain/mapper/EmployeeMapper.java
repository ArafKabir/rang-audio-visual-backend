package com.rang.rangaudiovisualbackend.domain.mapper;

import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;

public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee fromDTO(EmployeeDTO employeeDTO);
}
