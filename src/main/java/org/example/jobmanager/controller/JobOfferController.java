package org.example.jobmanager.controller;

import org.example.jobmanager.dto.JobOfferDTO;
import org.example.jobmanager.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-offers")
public class JobOfferController {
    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping
    public List<JobOfferDTO> getAllJobOffers() {
        return jobOfferService.getAllJobOffers();
    }

    @GetMapping("/{id}")
    public JobOfferDTO getJobOfferById(@PathVariable Long id) {
        return jobOfferService.getJobOfferById(id);
    }

    @PostMapping
    public JobOfferDTO createJobOffer(@RequestBody JobOfferDTO jobOfferDTO) {
        return jobOfferService.createJobOffer(jobOfferDTO);
    }

    @PutMapping("/{id}")
    public JobOfferDTO updateJobOffer(@PathVariable Long id, @RequestBody JobOfferDTO jobOfferDTO) {
        return jobOfferService.updateJobOffer(id, jobOfferDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJobOffer(@PathVariable Long id) {
        jobOfferService.deleteJobOffer(id);
    }
}
