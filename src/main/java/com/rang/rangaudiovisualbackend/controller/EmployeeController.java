package com.rang.rangaudiovisualbackend.controller;

import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.mapper.EmployeeMapper;
import com.rang.rangaudiovisualbackend.domain.mapper.impl.EmployeeMapperImpl;
import com.rang.rangaudiovisualbackend.service.EmployeeService;
import com.rang.rangaudiovisualbackend.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("/{email}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String email){
        try {
            Employee employee = employeeService.findByEmail(email);
            return ResponseEntity.ok(employeeMapper.toDTO(employee));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.createAccount(employeeDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteAccount(employeeId);
        return ResponseEntity.ok("Employee has been deleted");
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.updateAccount(employeeDTO));
    }
}
