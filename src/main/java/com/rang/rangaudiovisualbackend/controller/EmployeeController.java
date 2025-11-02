package com.rang.rangaudiovisualbackend.controller;

import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.mapper.EmployeeMapper;
import com.rang.rangaudiovisualbackend.domain.mapper.impl.EmployeeMapperImpl;
import com.rang.rangaudiovisualbackend.service.EmployeeService;
import com.rang.rangaudiovisualbackend.service.impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @GetMapping("/{email}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String email){
        try {
            Employee employee = employeeService.findByEmail(email);
            return ResponseEntity.ok(employeeMapper.toDTO(employee));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
