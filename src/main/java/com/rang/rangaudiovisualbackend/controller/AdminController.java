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

    @PostMapping("/create")
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok(adminMapper.toDTOSecure(adminService.createAccount(adminMapper.fromDTO(adminDTO))));
    }

    @PostMapping("/update")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok(adminService.updateAccount(adminDTO));
    }

    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long adminId) {
        adminService.deleteAccount(adminId);
        return ResponseEntity.ok("User has been deleted");
    }
}
