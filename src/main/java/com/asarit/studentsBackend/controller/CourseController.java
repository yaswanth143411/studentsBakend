package com.asarit.studentsBackend.controller;

import com.asarit.studentsBackend.dto.CourseDTO;

import com.asarit.studentsBackend.excepiton.CourseNotFoundException;
import com.asarit.studentsBackend.services.CourseService;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/register")
    public ResponseEntity<CourseDTO> register(@RequestBody CourseDTO courseDTO){
      return ResponseEntity.status(HttpStatus.CREATED).body(courseService.courseRegister(courseDTO));

    }
    @GetMapping("/getAllCourses")
    public List<CourseDTO> getAllCourses(){
       return courseService.getAllCourses();
    }

     @GetMapping("/getById/{courseId}")
        public ResponseEntity<CourseDTO> getCourseById(@PathVariable("courseId")Long courseId){
           CourseDTO courseDTO= courseService.getById(courseId);
            return ResponseEntity.status(HttpStatus.FOUND).body(courseDTO);

     }

  @PutMapping("/updateCourse")
  public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
       return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(courseDTO));
  }

  @DeleteMapping("/deleteCourse/{courseId}")
  public String deleteCourseById(@PathVariable("courseId") Long courseId) {
      courseService.deleteCourseById(courseId);
      return " Deleted successfully";
  }


}
