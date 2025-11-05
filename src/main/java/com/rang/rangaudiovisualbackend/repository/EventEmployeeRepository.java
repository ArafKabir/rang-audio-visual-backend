package com.rang.rangaudiovisualbackend.repository;

import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.entity.Event;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EventEmployeeRepository extends JpaRepository<EventEmployee, Integer> {
    boolean existsByEventAndEmployee(Event event, Employee employee);
    Optional<EventEmployee> findByEventAndEmployee(Event event, Employee employee);

}
