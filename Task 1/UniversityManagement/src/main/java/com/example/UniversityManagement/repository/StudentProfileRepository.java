package com.example.UniversityManagement.repository;

import com.example.UniversityManagement.entities.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Abdul Moiz Meer
 */
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}
