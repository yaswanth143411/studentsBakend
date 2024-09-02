package com.asarit.studentsBackend.mapper;

import com.asarit.studentsBackend.dto.StudentDTO;
import com.asarit.studentsBackend.model.Course;
import com.asarit.studentsBackend.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDTO studentDTO ,Course course) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setFatherName(studentDTO.getFatherName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setEmail(studentDTO.getEmail());
        student.setDob(studentDTO.getDob());
        student.setGender(studentDTO.getGender());
        student.setAdharNo(studentDTO.getAdharNo());
        student.setPhotoUrl(studentDTO.getPhotoUrl());
        student.setJoiningDate(studentDTO.getJoiningDate());
        student.setCourse(course);
        return student;






    }
    public StudentDTO toStudentDTO(Student student){
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getFatherName(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getDob(),
                student.getGender(),
                student.getAdharNo(),
                student.getPhotoUrl(),
                student.getJoiningDate(),
                student.getCourse().getId()

        );

    }
}
