package com.rang.rangaudiovisualbackend.repository;

import com.rang.rangaudiovisualbackend.domain.entity.Employee;
import com.rang.rangaudiovisualbackend.domain.entity.Event;
import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public interface EventEmployeeRepository extends JpaRepository<EventEmployee, Long> {
    boolean existsByEventAndEmployee(Event event, Employee employee);
    Optional<EventEmployee> findByEventAndEmployee(Event event, Employee employee);

    List<EventEmployee> findAllByEvent(Event event);

    List<EventEmployee> findAllByEmployee(Employee employee);
}
