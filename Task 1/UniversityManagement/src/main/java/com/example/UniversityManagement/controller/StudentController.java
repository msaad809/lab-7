package com.example.UniversityManagement.controller;

import com.example.UniversityManagement.dto.StudentDTO;
import com.example.UniversityManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Abdul Moiz Meer
 */
@RestController
@RequestMapping("/students")  // Base URL for student-related APIs
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    // ✅ API to enroll a student in a course
    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<String> enrollStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        String message = studentService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.ok(message);
    }
}
