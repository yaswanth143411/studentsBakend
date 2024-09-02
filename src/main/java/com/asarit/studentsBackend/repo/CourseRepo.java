package com.asarit.studentsBackend.repo;

import com.asarit.studentsBackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {

}
