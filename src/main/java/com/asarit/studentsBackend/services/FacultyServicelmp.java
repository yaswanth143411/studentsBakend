package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.FacultyDTO;
import com.asarit.studentsBackend.excepiton.CourseNotFoundException;
import com.asarit.studentsBackend.excepiton.FacultyNotFoundException;
import com.asarit.studentsBackend.mapper.FacultyMapper;
import com.asarit.studentsBackend.model.Course;
import com.asarit.studentsBackend.model.Faculty;
import com.asarit.studentsBackend.repo.CourseRepo;
import com.asarit.studentsBackend.repo.FacultyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServicelmp implements FacultyService{
    private  final FacultyRepo facultyRepo;
    private final CourseRepo courseRepo;
    private  final FacultyMapper facultyMapper;

    public FacultyServicelmp(FacultyRepo facultyRepo, CourseRepo courseRepo, FacultyMapper facultyMapper) {
        this.facultyRepo = facultyRepo;

        this.courseRepo = courseRepo;
        this.facultyMapper = facultyMapper;
    }

    @Override
    public FacultyDTO register(FacultyDTO facultyDTO) {
        Optional<Course> courseFromDb=courseRepo.findById(facultyDTO.getCourseId());
        if(courseFromDb.isEmpty()){
            throw new CourseNotFoundException("The given Id with this"+facultyDTO.getCourseId()+"is not found");
        }
        Course course=courseFromDb.get();
       Faculty faculty=facultyRepo.save(facultyMapper.toFaculty(facultyDTO,course));


        return facultyMapper.toFacultyDTO(faculty) ;
    }

    @Override
    public FacultyDTO getById(Long facultyId) {
        Optional<Faculty> facultyFromDb=facultyRepo.findById(facultyId);
        if(facultyFromDb.isEmpty()){
            throw new FacultyNotFoundException("The given id with this"+facultyId+"is not found");
        }
        return facultyMapper.toFacultyDTO(facultyFromDb.get());

    }

    @Override
    public List<FacultyDTO> getAllFaculty() {
        List<Faculty> facultyFromDb =facultyRepo.findAll();
        List<FacultyDTO> facultyDTOS=new ArrayList<>();
        for(Faculty faculty:facultyFromDb){
            FacultyDTO facultyDTO=facultyMapper.toFacultyDTO(faculty);
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }

    @Override
    public void deleteById(Long facultyId) {
        Optional<Faculty> facultyFromDb=facultyRepo.findById(facultyId);
        if(facultyFromDb.isEmpty()){
            throw new FacultyNotFoundException("The given id with this"+facultyId+"is not found");
        }
        facultyRepo.deleteById(facultyId);
    }

    @Override
    public FacultyDTO updateFaculty(FacultyDTO facultyDTO) {
        Optional<Faculty> facultyFromDb=facultyRepo.findById(facultyDTO.getId());
        Optional<Course> courseFromDb=courseRepo.findById(facultyDTO.getCourseId());
        if(facultyFromDb.isEmpty()){
            throw new FacultyNotFoundException("The given id with this"+facultyDTO.getId()+"is not found");
        }
        if(courseFromDb.isEmpty()){
            throw  new CourseNotFoundException("The given id with this"+facultyDTO.getCourseId()+"is not found");
        }
        Course course=courseFromDb.get();
        Faculty faculty=facultyMapper.toFaculty(facultyDTO,course);

        return facultyMapper.toFacultyDTO(facultyRepo.save(faculty));
    }


}
