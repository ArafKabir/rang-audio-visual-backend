package com.rang.rangaudiovisualbackend.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "event_date")
    private LocalDate date;

    @Column(name = "event_location")
    private String location;

    @OneToMany(mappedBy = "event", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EventEmployee> eventEmployees =  new HashSet<>();

}