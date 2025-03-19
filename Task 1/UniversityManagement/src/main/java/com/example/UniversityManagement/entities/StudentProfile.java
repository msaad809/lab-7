package com.example.UniversityManagement.entities;

import jakarta.persistence.*;
/**
 * @author Abdul Moiz Meer
 */
@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dob;
    private String address;
    private String contact;

    @OneToOne(mappedBy = "profile")
    private Student student;

    public StudentProfile() {}

    public StudentProfile(String dob, String address, String contact) {
        this.dob = dob;
        this.address = address;
        this.contact = contact;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
