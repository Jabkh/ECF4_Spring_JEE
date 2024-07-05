package org.example.jobmanager.service;

import org.example.jobmanager.dto.ApplicationDTO;
import org.example.jobmanager.model.Application;
import org.example.jobmanager.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // Récupérer toutes les candidatures
    public List<ApplicationDTO> getAllApplications() {
        return applicationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Récupérer une candidature par ID
    public ApplicationDTO getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Créer une nouvelle candidature
    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
        Application application = convertToEntity(applicationDTO);
        application = applicationRepository.save(application);
        return convertToDTO(application);
    }

    // Mettre à jour une candidature existante
    public ApplicationDTO updateApplication(Long id, ApplicationDTO applicationDTO) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        application.setCandidateName(applicationDTO.getCandidateName());
        application.setCandidateEmail(applicationDTO.getCandidateEmail());
        application.setApplicationDate(applicationDTO.getApplicationDate());

        application = applicationRepository.save(application);
        return convertToDTO(application);
    }

    // Supprimer une candidature par ID
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    // Convertir une entité Application en DTO
    private ApplicationDTO convertToDTO(Application application) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(application.getId());
        dto.setCandidateName(application.getCandidateName());
        dto.setCandidateEmail(application.getCandidateEmail());
        dto.setApplicationDate(application.getApplicationDate());

        // dto.setInterviews(interviewService.convertToDTOs(application.getInterviews()));
        return dto;
    }

    // Convertir un DTO en entité Application
    private Application convertToEntity(ApplicationDTO dto) {
        Application application = new Application();
        application.setId(dto.getId());
        application.setCandidateName(dto.getCandidateName());
        application.setCandidateEmail(dto.getCandidateEmail());
        application.setApplicationDate(dto.getApplicationDate());

        // application.setInterviews(interviewService.convertToEntities(dto.getInterviews()));
        return application;
    }
}
