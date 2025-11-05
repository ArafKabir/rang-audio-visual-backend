package com.rang.rangaudiovisualbackend.controller;


import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.mapper.AdminMapper;
import com.rang.rangaudiovisualbackend.domain.requests.LoginRequest;
import com.rang.rangaudiovisualbackend.service.AdminService;
import com.rang.rangaudiovisualbackend.service.impl.AdminServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path =  "api/v1/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AdminServiceImpl adminServiceImpl;
    private final AdminMapper adminMapper;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        try {
            AdminDTO loggedInAdmin = adminService.login(loginRequest);
            return ResponseEntity.ok(loggedInAdmin);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    @GetMapping("/{admin_email}")
    public ResponseEntity<Object> getAdminByEmail(@PathVariable String admin_email) {
        try{
            AdminDTO admin = adminServiceImpl.findByEmail(admin_email);
            return ResponseEntity.ok(admin);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok(adminService.createAccount(adminDTO));
    }

    @PostMapping("/update")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok(adminService.updateAccount(adminDTO));
    }

    @DeleteMapping("/delete/{admin_id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long admin_id) {
        adminService.deleteAccount(admin_id);
        return ResponseEntity.ok("User has been deleted");
    }
}
