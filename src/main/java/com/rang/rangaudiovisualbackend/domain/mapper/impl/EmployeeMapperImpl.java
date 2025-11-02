package com.rang.rangaudiovisualbackend.domain.mapper.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.mapper.EmployeeMapper;

public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public EmployeeDTO toDTO(Employee employee) {
        return new  EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHourlyRate()
        );
    }

    @Override
    public Employee fromDTO(EmployeeDTO employeeDTO) {
        if(employeeDTO == null){
            return null;
        }

        Employee employee = new Employee();
        employee.setId(employeeDTO.id());
        employee.setFirstName(employeeDTO.firstName());
        employee.setLastName(employeeDTO.lastName());
        employee.setEmail(employeeDTO.email());
        employee.setPhoneNumber(employeeDTO.phoneNumber());
        employee.setHourlyRate(employeeDTO.hourlyRate());

        return employee;
    }
}
