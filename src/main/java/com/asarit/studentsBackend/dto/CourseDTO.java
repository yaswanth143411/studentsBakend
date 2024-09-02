package com.asarit.studentsBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
    public class CourseDTO {
        private Long id;
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;
        private String duration;
        private Double amount;
        private Boolean isActive;

    }


