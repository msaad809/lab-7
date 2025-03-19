package com.example.UniversityManagement.service;

import com.example.UniversityManagement.dto.ProfessorDTO;
import com.example.UniversityManagement.entities.Course;
import com.example.UniversityManagement.entities.Professor;
import com.example.UniversityManagement.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Abdul Moiz Meer
 */
@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(Long id) {
        return professorRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
    }

    public ProfessorDTO addProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setName(professorDTO.getName());
        professor = professorRepository.save(professor);
        return convertToDTO(professor);
    }

    // ✅ Fix: Get all courses assigned to a professor
    public List<String> getCoursesByProfessor(Long professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        return professor.getCourses().stream()
                .map(Course::getTitle)
                .collect(Collectors.toList());
    }

    private ProfessorDTO convertToDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setName(professor.getName());
        dto.setCourses(professor.getCourses().stream().map(Course::getTitle).collect(Collectors.toSet()));
        return dto;
    }
}
