package com.rang.rangaudiovisualbackend.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_first_name")
    private String firstName;

    @Column(name = "employee_last_name")
    private String lastName;

    @Column(name ="employee_email", unique = true, nullable = false)
    private String email;

    @Column(name = "employee_phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "employee_hourly_rate")
    private double hourlyRate;
}

