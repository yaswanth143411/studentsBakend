package com.asarit.studentsBackend.controller;

import com.asarit.studentsBackend.dto.FacultyDTO;
import com.asarit.studentsBackend.services.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/register")
    public ResponseEntity<FacultyDTO> register(@RequestBody FacultyDTO facultyDTO){
       return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.register(facultyDTO));
    }
    @GetMapping("/getById/{facultyId}")
    public FacultyDTO getById(@PathVariable("facultyId")Long facultyId){
       return facultyService.getById(facultyId);
    }

    @GetMapping("/getAllFaculty")
    public List<FacultyDTO> getAllFaculty(){
       return facultyService.getAllFaculty();
    }

    @DeleteMapping("/deleteById/{facultyId}")
    public ResponseEntity<String> deleteById(@PathVariable("facultyId") Long facultyId){
        facultyService.deleteById(facultyId);
        return ResponseEntity.ok("Deleted Successfully");
    }

   @PutMapping("/updateFaculty")
    public  ResponseEntity<FacultyDTO>updateFaculty(@RequestBody FacultyDTO facultyDTO){
  return ResponseEntity.status(HttpStatus.OK).body(facultyService.updateFaculty(facultyDTO));
  }
}
