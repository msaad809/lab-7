package com.example.UniversityManagement.dto;

import java.util.Set;
/**
 * @author Abdul Moiz Meer
 */
public class CourseDTO {
    private Long id;
    private String title;
    private Long professorId; // Used to assign professor when creating a course
    private Set<StudentDTO> students; // Updated to hold student details

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }

    public Set<StudentDTO> getStudents() { return students; }
    public void setStudents(Set<StudentDTO> students) { this.students = students; }
}
