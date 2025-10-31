package com.rang.rangaudiovisualbackend.domain.entity;

import com.rang.rangaudiovisualbackend.domain.entity.EventEmployee;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "event_employee_id")
    private EventEmployee eventEmployee;

    public double getDurationInHours() {
        if (startTime != null && endTime != null) {
            return Duration.between(startTime, endTime).toMinutes() / 60.0;
        }
        return 0.0;
    }
}
