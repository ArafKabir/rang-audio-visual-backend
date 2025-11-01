package com.rang.rangaudiovisualbackend.service;

import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.requests.LoginRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AdminService {

   Admin login(LoginRequest loginRequest);
   AdminDTO createAccount(AdminDTO adminDto);
   Admin findByEmail(String email);
   void deleteAccount(Long id);
   AdminDTO updateAccount(AdminDTO newAdminDTO);
   List<AdminDTO> findAllAdmins();
}
