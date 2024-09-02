package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.FacultyDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FacultyService {
    FacultyDTO register(FacultyDTO facultyDTO);


    FacultyDTO getById(Long facultyId);

    List<FacultyDTO> getAllFaculty();

    void deleteById(Long facultyId);

    FacultyDTO updateFaculty(FacultyDTO facultyDTO);

}
