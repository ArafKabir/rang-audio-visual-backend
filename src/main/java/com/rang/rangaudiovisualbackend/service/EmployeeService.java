package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createAccount(EmployeeDTO employeeDTO);
    Employee findByEmail(String email);
    void deleteAccount(Long id);
    List<Employee> findAllEmployees();
    Employee updateAccount(Employee employee);
}
