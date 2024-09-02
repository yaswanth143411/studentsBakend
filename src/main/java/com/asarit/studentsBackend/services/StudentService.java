package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO register(StudentDTO studentDTO);

    StudentDTO getById(Long id);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudent(Long studentId);

    List<StudentDTO> getAllStudents();

}
