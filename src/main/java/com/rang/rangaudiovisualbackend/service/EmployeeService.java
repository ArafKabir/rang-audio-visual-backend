package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createAccount(Employee employee);
    Employee findByEmail(String email);
    void deleteAccount(Long id);
    List<Employee> findAllEmployees();
    Employee updateAccount(Employee employee);
}
