package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.mapper.EmployeeMapper;
import com.rang.rangaudiovisualbackend.domain.mapper.impl.EmployeeMapperImpl;
import com.rang.rangaudiovisualbackend.repository.EmployeeRepository;
import com.rang.rangaudiovisualbackend.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Override
    public EmployeeDTO createAccount(EmployeeDTO employeeDTO) {
        if(employeeDTO.email() ==  null ||  employeeDTO.phoneNumber() ==  null){
            throw new IllegalArgumentException("Email or phone number must not be null.");
        }

        Employee employee = employeeMapper.fromDTO(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toDTO(savedEmployee);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
    }

    @Override
    public void deleteAccount(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new IllegalArgumentException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return List.of();
    }

    @Override
    public Employee updateAccount(Employee employee) {
        return null;
    }
}
