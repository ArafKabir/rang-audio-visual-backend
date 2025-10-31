package com.rang.rangaudiovisualbackend.service.impl;

import com.rang.rangaudiovisualbackend.entity.Admin;
import com.rang.rangaudiovisualbackend.repository.AdminRepository;
import com.rang.rangaudiovisualbackend.requests.LoginRequest;
import com.rang.rangaudiovisualbackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public Admin login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Admin createAccount(Admin admin) {
        return null;
    }

    @Override
    public Admin findByEmail(String email) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }

    @Override
    public List<Admin> findAllAdmins() {
        return List.of();
    }

}
