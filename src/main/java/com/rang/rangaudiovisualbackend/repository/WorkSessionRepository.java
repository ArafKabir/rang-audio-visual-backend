package com.rang.rangaudiovisualbackend.repository;

import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkSessionRepository extends JpaRepository<WorkSession, Long> {
    List<WorkSession> findByEventEmployeeId(Long eventEmployeeId);
    List<WorkSession> findAllByEventEmployee(EventEmployee eventEmployee);
}
