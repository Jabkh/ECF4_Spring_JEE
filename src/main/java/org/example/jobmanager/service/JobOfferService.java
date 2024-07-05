package org.example.jobmanager.service;

import org.example.jobmanager.dto.JobOfferDTO;
import org.example.jobmanager.model.JobOffer;
import org.example.jobmanager.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobOfferService {
    @Autowired
    private JobOfferRepository jobOfferRepository;

    public List<JobOfferDTO> getAllJobOffers() {
        return jobOfferRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public JobOfferDTO getJobOfferById(Long id) {
        return jobOfferRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public JobOfferDTO createJobOffer(JobOfferDTO jobOfferDTO) {
        JobOffer jobOffer = convertToEntity(jobOfferDTO);
        jobOffer = jobOfferRepository.save(jobOffer);
        return convertToDTO(jobOffer);
    }

    public JobOfferDTO updateJobOffer(Long id, JobOfferDTO jobOfferDTO) {
        JobOffer jobOffer = jobOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("JobOffer not found"));
        jobOffer.setTitle(jobOfferDTO.getTitle());
        jobOffer.setDescription(jobOfferDTO.getDescription());
        jobOffer.setPostedDate(jobOfferDTO.getPostedDate());
        jobOffer.setClosingDate(jobOfferDTO.getClosingDate());
        jobOffer = jobOfferRepository.save(jobOffer);
        return convertToDTO(jobOffer);
    }

    public void deleteJobOffer(Long id) {
        jobOfferRepository.deleteById(id);
    }

    private JobOfferDTO convertToDTO(JobOffer jobOffer) {
        JobOfferDTO dto = new JobOfferDTO();
        dto.setId(jobOffer.getId());
        dto.setTitle(jobOffer.getTitle());
        dto.setDescription(jobOffer.getDescription());
        dto.setPostedDate(jobOffer.getPostedDate());
        dto.setClosingDate(jobOffer.getClosingDate());
        return dto;
    }

    private JobOffer convertToEntity(JobOfferDTO dto) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId(dto.getId());
        jobOffer.setTitle(dto.getTitle());
        jobOffer.setDescription(dto.getDescription());
        jobOffer.setPostedDate(dto.getPostedDate());
        jobOffer.setClosingDate(dto.getClosingDate());
        return jobOffer;
    }
}