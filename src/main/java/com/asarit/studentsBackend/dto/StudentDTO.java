package com.asarit.studentsBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
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
    private Long courseId;



}
