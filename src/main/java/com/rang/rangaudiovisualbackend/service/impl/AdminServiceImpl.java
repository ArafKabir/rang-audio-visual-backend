package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.mapper.AdminMapper;
import com.rang.rangaudiovisualbackend.domain.mapper.impl.AdminMapperImpl;
import com.rang.rangaudiovisualbackend.repository.AdminRepository;
import com.rang.rangaudiovisualbackend.domain.requests.LoginRequest;
import com.rang.rangaudiovisualbackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Admin login(LoginRequest loginRequest) {
        if (loginRequest.email() == null || loginRequest.password() == null) {
            throw new IllegalArgumentException("Email or password is missing");
        }

        Optional<Admin> adminOptional = adminRepository.findByEmail(loginRequest.email());

        Admin admin = adminOptional.orElseThrow
                (() -> new IllegalArgumentException("Invalid email or password"));

        // hashing the entered password and checking if it matches with the original one
        if (!passwordEncoder.matches(loginRequest.password(), admin.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return admin;
    }


    @Override
    public Admin createAccount(Admin admin) {
        // saving the password in the database after hashing it
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));
    }

    @Override
    public void deleteAccount(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new IllegalArgumentException("Admin not found with id: " + id);
        }
        adminRepository.deleteById(id);
    }

    @Override
    public Admin updateAccount(Admin updatedAdmin) {

        //Finding the admin from the database
        Admin existingAdmin = adminRepository.findById(updatedAdmin.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));

        // update email
        if (updatedAdmin.getEmail() != null && !updatedAdmin.getEmail().isEmpty()) {
            existingAdmin.setEmail(updatedAdmin.getEmail());
        }

        // update password
        if (updatedAdmin.getPassword() != null && !updatedAdmin.getPassword().isEmpty()) {
            existingAdmin.setPassword(updatedAdmin.getPassword());
        }

        // update name
        if (updatedAdmin.getName() != null && !updatedAdmin.getName().isEmpty()) {
            existingAdmin.setName(updatedAdmin.getName());
        }

        // update phone number
        if (updatedAdmin.getPhoneNumber() != null && !updatedAdmin.getPhoneNumber().isEmpty()) {
            existingAdmin.setPhoneNumber(updatedAdmin.getPhoneNumber());
        }

        // update Role
        if (updatedAdmin.getRole() != null && !updatedAdmin.getRole().isEmpty()) {
            existingAdmin.setRole(updatedAdmin.getRole());

        }

        return adminRepository.save(existingAdmin);
    }

    @Override
    public List<AdminDTO> findAllAdmins() {
        AdminMapper adminMapper = new AdminMapperImpl();
        // hiding the password by transferring it to a AdminDTO
        return adminRepository.findAll().stream().map(adminMapper::toDTOSecure).collect(Collectors.toList());
    }

}
