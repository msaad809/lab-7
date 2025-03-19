package com.example.UniversityManagement.service;

import com.example.UniversityManagement.dto.StudentDTO;
import com.example.UniversityManagement.entities.Course;
import com.example.UniversityManagement.entities.Student;
import com.example.UniversityManagement.entities.StudentProfile;
import com.example.UniversityManagement.repository.StudentRepository;
import com.example.UniversityManagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Abdul Moiz Meer
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());

        // ✅ Add profile to student
        StudentProfile profile = new StudentProfile();
        profile.setDob(studentDTO.getDob());
        profile.setAddress(studentDTO.getAddress());
        profile.setContact(studentDTO.getContact());
        student.setProfile(profile);

        student = studentRepository.save(student);
        return convertToDTO(student);
    }

    // ✅ Fix: Add student enrollment method
    public String enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);  // Add course to student
        studentRepository.save(student);   // Save changes

        return "Student " + studentId + " enrolled in Course " + courseId;
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setDob(student.getProfile().getDob());
        dto.setAddress(student.getProfile().getAddress());
        dto.setContact(student.getProfile().getContact());
        dto.setCourses(student.getCourses().stream().map(course -> course.getTitle()).collect(Collectors.toSet()));
        return dto;
    }
}
