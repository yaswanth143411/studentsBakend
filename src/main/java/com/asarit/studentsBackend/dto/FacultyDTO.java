package com.asarit.studentsBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String experience;
    private LocalDate joinDate;
    private LocalDate resignedDate;
    private Long courseId;
}
