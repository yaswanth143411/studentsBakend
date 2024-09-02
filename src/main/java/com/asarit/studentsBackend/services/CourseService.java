package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.CourseDTO;
import com.asarit.studentsBackend.excepiton.CourseNotFoundException;
import com.asarit.studentsBackend.model.Course;

import java.util.List;

public interface CourseService {

    CourseDTO courseRegister(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();

    CourseDTO getById(Long courseId) ;


    void deleteCourseById(Long courseId) ;


    CourseDTO updateCourse(CourseDTO courseDTO);

}
