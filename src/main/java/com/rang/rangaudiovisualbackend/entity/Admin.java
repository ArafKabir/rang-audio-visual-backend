package com.rang.rangaudiovisualbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_email",nullable = false, unique = true)
    private String email;

    @Column(name = "admin_password", nullable = false)
    private String password;

    @Column(name = "admin_phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "admin_role")
    private String role;
}