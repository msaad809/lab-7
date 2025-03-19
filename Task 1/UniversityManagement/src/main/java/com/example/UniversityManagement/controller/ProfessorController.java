package com.example.UniversityManagement.controller;

import com.example.UniversityManagement.dto.ProfessorDTO;
import com.example.UniversityManagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Abdul Moiz Meer
 */
@RestController
@RequestMapping("/professors")  // Base URL for professor-related APIs
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public ProfessorDTO getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @PostMapping
    public ProfessorDTO addProfessor(@RequestBody ProfessorDTO professorDTO) {
        return professorService.addProfessor(professorDTO);
    }

    // ✅ Fix: API to get courses assigned to a professor
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<String>> getCoursesByProfessor(@PathVariable Long id) {
        List<String> courses = professorService.getCoursesByProfessor(id);
        return ResponseEntity.ok(courses);
    }
}
