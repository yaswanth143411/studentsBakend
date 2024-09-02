package com.asarit.studentsBackend.controller;

import com.asarit.studentsBackend.dto.StudentDTO;
import com.asarit.studentsBackend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/student/")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody StudentDTO studentDTO){
      studentService.register(studentDTO);
      return ResponseEntity.ok("sdfghj");
    }
    @GetMapping("getAllStudents")
    public List<StudentDTO>getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("/getById/{id}")
    public StudentDTO getById(@PathVariable("id") Long id){
       return  studentService.getById(id);
    }
    @PutMapping("/updateStudent")
    public void updateStudent(@RequestBody StudentDTO studentDTO){
    studentService.updateStudent(studentDTO);


    }
    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
       return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
    }



}
