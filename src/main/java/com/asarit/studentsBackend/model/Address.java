package com.asarit.studentsBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doorNo;
    private String street;
    private String village;
    private String mandal;
    private String district;
    private String state;
    private String country;
    private Integer pinCode;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
}
