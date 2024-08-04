package com.asarit.studentsBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fatherName;
    private String phoneNumber;
    private String email;
    private LocalDate dob;
    private String gender;
    private String adharNo;
    private String photoUrl;
    private LocalDate joiningDate;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Address> addresses;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private Course course;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL ,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Bill> bills;

}
