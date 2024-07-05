package org.example.jobmanager.service;

import org.example.jobmanager.dto.CandidateDTO;
import org.example.jobmanager.model.Candidate;
import org.example.jobmanager.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    // Récupérer tous les candidats
    public List<CandidateDTO> getAllCandidates() {
        return candidateRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Récupérer un candidat par ID
    public CandidateDTO getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Créer un nouveau candidat
    public CandidateDTO createCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = convertToEntity(candidateDTO);
        candidate = candidateRepository.save(candidate);
        return convertToDTO(candidate);
    }

    // Mettre à jour un candidat existant
    public CandidateDTO updateCandidate(Long id, CandidateDTO candidateDTO) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate.setName(candidateDTO.getName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setBirthDate(candidateDTO.getBirthDate());
        // Vous pouvez ajouter plus de champs à mettre à jour ici
        candidate = candidateRepository.save(candidate);
        return convertToDTO(candidate);
    }

    // Supprimer un candidat par ID
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    // Convertir une entité Candidate en DTO
    private CandidateDTO convertToDTO(Candidate candidate) {
        CandidateDTO dto = new CandidateDTO();
        dto.setId(candidate.getId());
        dto.setName(candidate.getName());
        dto.setEmail(candidate.getEmail());
        dto.setBirthDate(candidate.getBirthDate());
        // Si besoin, ajouter la conversion pour les Applications associées
        // dto.setApplications(applicationService.convertToDTOs(candidate.getApplications()));
        return dto;
    }

    // Convertir un DTO en entité Candidate
    private Candidate convertToEntity(CandidateDTO dto) {
        Candidate candidate = new Candidate();
        candidate.setId(dto.getId());
        candidate.setName(dto.getName());
        candidate.setEmail(dto.getEmail());
        candidate.setBirthDate(dto.getBirthDate());
        // Si besoin, ajouter la conversion pour les Applications associées
        // candidate.setApplications(applicationService.convertToEntities(dto.getApplications()));
        return candidate;
    }
}

