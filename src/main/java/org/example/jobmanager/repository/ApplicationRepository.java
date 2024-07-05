package org.example.jobmanager.repository;



import org.example.jobmanager.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Méthodes de requête personnalisées si nécessaire
}