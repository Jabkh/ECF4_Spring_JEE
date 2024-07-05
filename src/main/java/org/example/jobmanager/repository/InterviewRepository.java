package org.example.jobmanager.repository;

import org.example.jobmanager.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    // Méthodes de requête personnalisées si nécessaire
}