package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.mapper.AdminMapper;
import com.rang.rangaudiovisualbackend.domain.mapper.impl.AdminMapperImpl;
import com.rang.rangaudiovisualbackend.repository.AdminRepository;
import com.rang.rangaudiovisualbackend.domain.requests.LoginRequest;
import com.rang.rangaudiovisualbackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final AdminMapper adminMapper;

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
    public AdminDTO createAccount(AdminDTO adminDTO) {

        if (adminDTO.email() == null || adminDTO.password() == null) {
            throw new IllegalArgumentException("Email and password must not be null");
        }

        if (adminRepository.findByEmail(adminDTO.email()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        Admin admin = adminMapper.fromDTO(adminDTO);

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        Admin savedAdmin = adminRepository.save(admin);

        return adminMapper.toDTOSecure(savedAdmin);
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
    public AdminDTO updateAccount(AdminDTO updatedAdminDTO) {


        Admin existingAdmin = adminRepository.findById(updatedAdminDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid admin ID"));


        if (updatedAdminDTO.email() != null && !updatedAdminDTO.email().isEmpty()) {
            existingAdmin.setEmail(updatedAdminDTO.email());
        }

        if (updatedAdminDTO.password() != null && !updatedAdminDTO.password().isEmpty()) {
            // hash the password before saving
            existingAdmin.setPassword(passwordEncoder.encode(updatedAdminDTO.password()));
        }

        if (updatedAdminDTO.name() != null && !updatedAdminDTO.name().isEmpty()) {
            existingAdmin.setName(updatedAdminDTO.name());
        }

        if (updatedAdminDTO.phoneNumber() != null && !updatedAdminDTO.phoneNumber().isEmpty()) {
            existingAdmin.setPhoneNumber(updatedAdminDTO.phoneNumber());
        }

        if (updatedAdminDTO.role() != null && !updatedAdminDTO.role().isEmpty()) {
            existingAdmin.setRole(updatedAdminDTO.role());
        }

        Admin savedAdmin = adminRepository.save(existingAdmin);

        return adminMapper.toDTOSecure(savedAdmin);
    }


    @Override
    public List<AdminDTO> findAllAdmins() {
        AdminMapper adminMapper = new AdminMapperImpl();
        // hiding the password by transferring it to a AdminDTO
        return adminRepository.findAll().stream().map(adminMapper::toDTOSecure).collect(Collectors.toList());
    }

}
