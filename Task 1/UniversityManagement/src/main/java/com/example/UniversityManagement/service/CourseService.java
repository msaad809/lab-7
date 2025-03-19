package com.example.UniversityManagement.service;

import com.example.UniversityManagement.dto.CourseDTO;
import com.example.UniversityManagement.entities.Course;
import com.example.UniversityManagement.entities.Professor;
import com.example.UniversityManagement.repository.CourseRepository;
import com.example.UniversityManagement.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Abdul Moiz Meer
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());

        // ✅ Assign professor to course
        Professor professor = professorRepository.findById(courseDTO.getProfessorId()).orElse(null);
        if (professor == null) {
            throw new RuntimeException("Professor not found!");
        }
        course.setProfessor(professor);

        course = courseRepository.save(course);
        return convertToDTO(course);
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setProfessorId(course.getProfessor().getId());
        dto.setStudents(course.getStudents().stream().map(student -> student.getName()).collect(Collectors.toSet()));
        return dto;
    }
}
