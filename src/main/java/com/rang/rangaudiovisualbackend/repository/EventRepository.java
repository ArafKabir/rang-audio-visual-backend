package com.rang.rangaudiovisualbackend.repository;

import com.rang.rangaudiovisualbackend.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
