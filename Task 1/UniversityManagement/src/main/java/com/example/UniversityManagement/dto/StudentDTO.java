package com.example.UniversityManagement.dto;

import java.util.Set;
/**
 * @author Abdul Moiz Meer
 */
public class StudentDTO {
    private Long id;
    private String name;
    private String dob;
    private String address;
    private String contact;
    private Set<CourseDTO> courses; // Change to Set<CourseDTO>

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public Set<CourseDTO> getCourses() { return courses; } // Change to Set<CourseDTO>
    public void setCourses(Set<CourseDTO> courses) { this.courses = courses; }
}
