package org.example.jobmanager.repository;

import org.example.jobmanager.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Méthodes de requête personnalisées si nécessaire
}