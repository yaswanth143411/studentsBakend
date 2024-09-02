package com.asarit.studentsBackend.dto;

import com.asarit.studentsBackend.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {
    private Long id;
    private LocalDate paymentDate;
    private Double amount;
    private Long studentId;
}
