package com.rang.rangaudiovisualbackend.repository;

import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
}
