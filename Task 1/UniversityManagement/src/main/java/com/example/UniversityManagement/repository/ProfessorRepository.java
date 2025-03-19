package com.example.UniversityManagement.repository;

import com.example.UniversityManagement.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Abdul Moiz Meer
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
