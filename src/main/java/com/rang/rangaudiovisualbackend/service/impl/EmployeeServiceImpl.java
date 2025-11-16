package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.EmployeeDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.mapper.EmployeeMapper;
import com.rang.rangaudiovisualbackend.domain.mapper.impl.EmployeeMapperImpl;
import com.rang.rangaudiovisualbackend.repository.EmployeeRepository;
import com.rang.rangaudiovisualbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
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
    public Employee findById(Long id) {
        return  employeeRepository.findById(id)
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
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateAccount(EmployeeDTO updatedEmployeeDTO) {
        Employee existingEmployee = employeeRepository.findById(updatedEmployeeDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));

        if (updatedEmployeeDTO.firstName() != null && !updatedEmployeeDTO.firstName().isEmpty()) {
            // hash the password before saving
            existingEmployee.setFirstName(updatedEmployeeDTO.firstName());
        }

        if (updatedEmployeeDTO.lastName() != null && !updatedEmployeeDTO.lastName().isEmpty()) {
            existingEmployee.setLastName(updatedEmployeeDTO.lastName());
        }

        if (updatedEmployeeDTO.email() != null && !updatedEmployeeDTO.email().isEmpty()) {
            existingEmployee.setEmail(updatedEmployeeDTO.email());
        }

        if (updatedEmployeeDTO.phoneNumber() != null && !updatedEmployeeDTO.phoneNumber().isEmpty()) {
            existingEmployee.setPhoneNumber(updatedEmployeeDTO.phoneNumber());
        }

        if (updatedEmployeeDTO.hourlyRate() != null && !updatedEmployeeDTO.hourlyRate().isNaN()) {
            existingEmployee.setHourlyRate(updatedEmployeeDTO.hourlyRate());
        }

        Employee savedEmployee = employeeRepository.save(existingEmployee);

        return employeeMapper.toDTO(savedEmployee);
    }
}
