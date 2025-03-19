package com.example.UniversityManagement.controller;

import com.example.UniversityManagement.dto.CourseDTO;
import com.example.UniversityManagement.dto.StudentDTO;
import com.example.UniversityManagement.service.CourseService;
import com.example.UniversityManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Abdul Moiz Meer
 */
@RestControllerMuhammad Saad
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private   CourseService courseService;

    @Autowired
    private StudentService studentService;

    // Get all courses
    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Add a new course
    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.addCourse(courseDTO);
    }

    // Get all students in a specific course
    @GetMapping("/{courseId}/students")
    public List<StudentDTO> getStudentsInCourse(@PathVariable Long courseId) {
        return studentService.getStudentsByCourseId(courseId);  // Assuming StudentService has this method
    }
}
