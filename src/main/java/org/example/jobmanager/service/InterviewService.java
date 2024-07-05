package org.example.jobmanager.service;

import org.example.jobmanager.dto.InterviewDTO;
import org.example.jobmanager.model.Interview;
import org.example.jobmanager.repository.InterviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    // Récupérer tous les entretiens
    public List<InterviewDTO> getAllInterviews() {
        return interviewRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Récupérer un entretien par ID
    public InterviewDTO getInterviewById(Long id) {
        return interviewRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Créer un nouvel entretien
    public InterviewDTO createInterview(InterviewDTO interviewDTO) {
        Interview interview = convertToEntity(interviewDTO);
        interview = interviewRepository.save(interview);
        return convertToDTO(interview);
    }

    // Mettre à jour un entretien existant
    public InterviewDTO updateInterview(Long id, InterviewDTO interviewDTO) {
        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
        interview.setInterviewDate(interviewDTO.getInterviewDate());
        interview.setInterviewer(interviewDTO.getInterviewer());
        interview.setInterviewType(interviewDTO.getInterviewType());
        // Vous pouvez ajouter plus de champs à mettre à jour ici
        interview = interviewRepository.save(interview);
        return convertToDTO(interview);
    }

    // Supprimer un entretien par ID
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }

    // Convertir une entité Interview en DTO
    private InterviewDTO convertToDTO(Interview interview) {
        InterviewDTO dto = new InterviewDTO();
        dto.setId(interview.getId());
        dto.setInterviewDate(interview.getInterviewDate());
        dto.setInterviewer(interview.getInterviewer());
        dto.setInterviewType(interview.getInterviewType());

        // dto.setApplication(applicationService.convertToDTO(interview.getApplication()));
        return dto;
    }

    // Convertir un DTO en entité Interview
    private Interview convertToEntity(InterviewDTO dto) {
        Interview interview = new Interview();
        interview.setId(dto.getId());
        interview.setInterviewDate(dto.getInterviewDate());
        interview.setInterviewer(dto.getInterviewer());
        interview.setInterviewType(dto.getInterviewType());

        // interview.setApplication(applicationService.convertToEntity(dto.getApplication()));
        return interview;
    }
}
