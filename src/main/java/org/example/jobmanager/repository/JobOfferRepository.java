package org.example.jobmanager.repository;

import org.example.jobmanager.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
    // Méthodes de requête personnalisées si nécessaire
}