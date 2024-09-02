package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.CourseDTO;
import com.asarit.studentsBackend.excepiton.CourseNotFoundException;
import com.asarit.studentsBackend.mapper.CourseMapper;
import com.asarit.studentsBackend.model.Course;
import com.asarit.studentsBackend.repo.CourseRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServicelmp implements CourseService{
  private  final CourseRepo courseRepo;
  private final CourseMapper courseMapper;

    public CourseServicelmp(CourseRepo courseRepo, CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDTO courseRegister(CourseDTO courseDTO) {
       Course courseFromDb= courseRepo.save(courseMapper.toCourse(courseDTO));
        return courseMapper.toCourseDTO(courseFromDb);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> coursesFromDb = courseRepo.findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();

        for (Course course : coursesFromDb) {
            CourseDTO courseDTO = courseMapper.toCourseDTO(course);
            courseDTOs.add(courseDTO);
        }

        return courseDTOs;
    }




    @Override
    public CourseDTO getById(Long courseId)  {
        Optional<Course> courseFromDb=courseRepo.findById(courseId);
        if(courseFromDb.isEmpty()){
            throw new CourseNotFoundException("Given id in this"+courseId+"not Found");
        }
        return courseMapper.toCourseDTO(courseFromDb.get());
    }

    @Override
    public void deleteCourseById(Long courseId) {
        Optional<Course> course=courseRepo.findById(courseId);
        if(course.isEmpty()){
            throw new CourseNotFoundException("The given id with this"+courseId+"is not found");
        }
        courseRepo.deleteById(courseId);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        Optional<Course> courseFromDb=courseRepo.findById(courseDTO.getId());
        if(courseFromDb.isEmpty()){
            throw new CourseNotFoundException("The given id with this"+courseDTO.getId()+"is not found");
        }
            Course course = courseRepo.save(courseMapper.toCourse(courseDTO));
            return courseMapper.toCourseDTO(course);


    }




}
