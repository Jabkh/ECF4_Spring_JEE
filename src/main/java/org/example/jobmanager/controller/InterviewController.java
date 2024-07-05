package org.example.jobmanager.controller;

import org.example.jobmanager.dto.InterviewDTO;
import org.example.jobmanager.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    // Récupérer tous les entretiens
    @GetMapping
    public ResponseEntity<List<InterviewDTO>> getAllInterviews() {
        List<InterviewDTO> interviews = interviewService.getAllInterviews();
        return ResponseEntity.ok(interviews);
    }

    // Récupérer un entretien par ID
    @GetMapping("/{id}")
    public ResponseEntity<InterviewDTO> getInterviewById(@PathVariable Long id) {
        InterviewDTO interview = interviewService.getInterviewById(id);
        return interview != null ? ResponseEntity.ok(interview) : ResponseEntity.notFound().build();
    }

    // Créer un nouvel entretien
    @PostMapping
    public ResponseEntity<InterviewDTO> createInterview(@RequestBody InterviewDTO interviewDTO) {
        InterviewDTO createdInterview = interviewService.createInterview(interviewDTO);
        return ResponseEntity.ok(createdInterview);
    }

    // Mettre à jour un entretien existant
    @PutMapping("/{id}")
    public ResponseEntity<InterviewDTO> updateInterview(@PathVariable Long id, @RequestBody InterviewDTO interviewDTO) {
        InterviewDTO updatedInterview = interviewService.updateInterview(id, interviewDTO);
        return updatedInterview != null ? ResponseEntity.ok(updatedInterview) : ResponseEntity.notFound().build();
    }

    // Supprimer un entretien par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long id) {
        interviewService.deleteInterview(id);
        return ResponseEntity.noContent().build();
    }
}
