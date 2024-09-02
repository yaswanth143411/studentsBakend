package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.StudentDTO;
import com.asarit.studentsBackend.excepiton.CourseNotFoundException;
import com.asarit.studentsBackend.excepiton.StudentNotFoundException;
import com.asarit.studentsBackend.mapper.StudentMapper;
import com.asarit.studentsBackend.model.Course;
import com.asarit.studentsBackend.model.Student;
import com.asarit.studentsBackend.repo.CourseRepo;
import com.asarit.studentsBackend.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServicelmp implements StudentService{
   public final StudentRepo studentRepo;
   public final StudentMapper studentMapper;
   private final CourseRepo courseRepo;

    public StudentServicelmp(StudentRepo studentRepo, StudentMapper studentMapper, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
        this.courseRepo = courseRepo;
    }

    @Override
    public StudentDTO register(StudentDTO studentDTO) {
        Optional<Course> courseFromDb=courseRepo.findById(studentDTO.getCourseId());
        if(courseFromDb.isEmpty()){
            throw new CourseNotFoundException("The give id with this"+studentDTO.getCourseId()+"is not found");
        }
       Course course=courseFromDb.get();
        Student student =studentMapper.toStudent(studentDTO,course);
        student.setCourse(courseRepo.findById(studentDTO.getCourseId()).get());
        studentRepo.save(student);
        return studentMapper.toStudentDTO(studentRepo.save(student));
    }

    @Override
    public StudentDTO getById(Long id) {
        Student studentFromDb=studentRepo.findById(id).get();
        return studentMapper.toStudentDTO(studentFromDb );
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Optional<Course> optionalCourse=courseRepo.findById(studentDTO.getCourseId());
       Optional<Student> studentFromDb= studentRepo.findById(studentDTO.getId());
        if(optionalCourse.isEmpty()){
            throw new RuntimeException("The give id with this"+studentDTO.getCourseId()+"is not found");
        }
        if(studentFromDb.isEmpty()){
            throw new StudentNotFoundException("The give id with this"+studentDTO.getId()+"is not found");
        }
        Course course=optionalCourse.get();
       Student student= studentMapper.toStudent(studentDTO,course);
       studentRepo.save(student);

    }


    @Override
    public void deleteStudent(Long studentId) {
        Optional<Student> studentFromDb=studentRepo.findById(studentId);
        if(studentFromDb.isEmpty()){
            throw new StudentNotFoundException("The give id with this"+studentId+"is not found");
        }
        studentRepo.deleteById(studentId);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> studentFromDb=studentRepo.findAll();
        List<StudentDTO> studentDTOS=new ArrayList<>();
        for(Student student:studentFromDb){
            StudentDTO studentDTO=studentMapper.toStudentDTO(student);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS ;
    }
}
