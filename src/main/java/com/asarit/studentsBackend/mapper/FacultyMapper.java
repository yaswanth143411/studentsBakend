package com.asarit.studentsBackend.mapper;

import com.asarit.studentsBackend.dto.FacultyDTO;
import com.asarit.studentsBackend.model.Course;
import com.asarit.studentsBackend.model.Faculty;
import org.springframework.stereotype.Service;

@Service
public class FacultyMapper {
    public Faculty toFaculty(FacultyDTO facultyDTO, Course course){
        Faculty faculty=new Faculty();
        faculty.setId(facultyDTO.getId());
        faculty.setName(facultyDTO.getName());
        faculty.setPhoneNumber(facultyDTO.getPhoneNumber());
        faculty.setExperience(facultyDTO.getExperience());
        faculty.setJoinDate(facultyDTO.getJoinDate());
        faculty.setResignedDate(facultyDTO.getResignedDate());
        faculty.setCourse(course);
        return faculty;
    }
    public FacultyDTO toFacultyDTO(Faculty faculty){
        return new FacultyDTO(
                faculty.getId(),
                faculty.getName(),
                faculty.getPhoneNumber(),
                faculty.getExperience(),
                faculty.getJoinDate(),
                faculty.getResignedDate(),
                faculty.getCourse().getId()
        );
    }

}
