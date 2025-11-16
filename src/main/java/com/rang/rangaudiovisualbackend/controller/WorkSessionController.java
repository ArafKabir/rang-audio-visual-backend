package com.rang.rangaudiovisualbackend.controller;


import com.rang.rangaudiovisualbackend.domain.dto.WorkSessionDTO;
import com.rang.rangaudiovisualbackend.service.WorkSessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/v1/session")
public class WorkSessionController {
    private final WorkSessionService workSessionService;

    @PostMapping("/create/{eventId}/{employeeId}")
    public ResponseEntity<WorkSessionDTO> createSession(@PathVariable Long eventId, @PathVariable Long employeeId,@RequestBody WorkSessionDTO workSessionDTO) {
        return ResponseEntity.ok(workSessionService.createSession(eventId, employeeId, workSessionDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<WorkSessionDTO> updateSession(@RequestBody WorkSessionDTO workSessionDTO) {
        return ResponseEntity.ok(workSessionService.updateSession(workSessionDTO));
    }

    @DeleteMapping("/delete/{sessionId}")
    public ResponseEntity<String> deleteSession(@PathVariable Long sessionId) {
        workSessionService.deleteSession(sessionId);
        return  ResponseEntity.ok("Session has been deleted");
    }

    @GetMapping("/all/{eventId}/{employeeId}")
    public ResponseEntity<List<WorkSessionDTO>> getAllSessionsForEventEmployee(@PathVariable Long eventId, @PathVariable Long employeeId) {
        return ResponseEntity.ok(workSessionService.getAllSessionsByEventEmployee(eventId, employeeId));
    }

}
