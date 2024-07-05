package org.example.jobmanager.controller;

import org.example.jobmanager.dto.CandidateDTO;
import org.example.jobmanager.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    // Récupérer tous les candidats
    @GetMapping
    public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
        List<CandidateDTO> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

    // Récupérer un candidat par ID
    @GetMapping("/{id}")
    public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable Long id) {
        CandidateDTO candidate = candidateService.getCandidateById(id);
        return candidate != null ? ResponseEntity.ok(candidate) : ResponseEntity.notFound().build();
    }

    // Créer un nouveau candidat
    @PostMapping
    public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateDTO candidateDTO) {
        CandidateDTO createdCandidate = candidateService.createCandidate(candidateDTO);
        return ResponseEntity.ok(createdCandidate);
    }

    // Mettre à jour un candidat existant
    @PutMapping("/{id}")
    public ResponseEntity<CandidateDTO> updateCandidate(@PathVariable Long id, @RequestBody CandidateDTO candidateDTO) {
        CandidateDTO updatedCandidate = candidateService.updateCandidate(id, candidateDTO);
        return updatedCandidate != null ? ResponseEntity.ok(updatedCandidate) : ResponseEntity.notFound().build();
    }

    // Supprimer un candidat par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }
}
