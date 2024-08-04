package com.asarit.studentsBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String experience;
    private LocalDate joinDate;
    private LocalDate resignedDate;

    @OneToOne
    @JoinColumn(name = "courseId")
    private Course course;
}
