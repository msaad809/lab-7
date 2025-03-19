package com.example.UniversityManagement.repository;

import com.example.UniversityManagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Abdul Moiz Meer
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
