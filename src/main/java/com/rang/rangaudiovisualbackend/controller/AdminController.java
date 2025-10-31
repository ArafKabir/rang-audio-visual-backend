package com.rang.rangaudiovisualbackend.controller;


import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.mapper.AdminMapper;
import com.rang.rangaudiovisualbackend.domain.requests.LoginRequest;
import com.rang.rangaudiovisualbackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path =  "api/v1/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AdminMapper adminMapper;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        AdminDTO response;
        try {
            response = adminMapper.toDTOSecure(adminService.login(loginRequest));
        } catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
