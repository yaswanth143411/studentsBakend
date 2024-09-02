package com.asarit.studentsBackend.mapper;

import com.asarit.studentsBackend.dto.CourseDTO;
import com.asarit.studentsBackend.model.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    public Course toCourse(CourseDTO courseDTO){
        Course course=new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setStartDate(courseDTO.getStartDate());
        course.setEndDate(courseDTO.getEndDate());
        course.setDuration(courseDTO.getDuration());
        course.setAmount(courseDTO.getAmount());
        course.setIsActive(courseDTO.getIsActive());
        return course;

    }

    public CourseDTO toCourseDTO(Course courseFromDb) {
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setId(courseFromDb.getId());
        courseDTO.setName(courseFromDb.getName());
        courseDTO.setStartDate(courseFromDb.getStartDate());
        courseDTO.setEndDate(courseFromDb.getEndDate());
        courseDTO.setDuration(courseFromDb.getDuration());
        courseDTO.setAmount(courseFromDb.getAmount());
        courseDTO.setIsActive(courseFromDb.getIsActive());
        return courseDTO;

    }
}

