package com.example.UniversityManagement.repository;

import com.example.UniversityManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Abdul Moiz Meer
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom method to find students by course ID
    List<Student> findByCoursesId(Long courseId);
}
