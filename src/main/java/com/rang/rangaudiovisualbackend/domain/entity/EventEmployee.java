package com.rang.rangaudiovisualbackend.domain.entity;
import com.rang.rangaudiovisualbackend.domain.entity.WorkSession;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "event_employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_employee_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "eventEmployee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkSession> workSessions = new java.util.ArrayList<>();

    // Derived field (not stored directly, just computed)
    public double getTotalHoursWorked() {
        return workSessions.stream()
                .mapToDouble(WorkSession::getDurationInHours)
                .sum();
    }
}
