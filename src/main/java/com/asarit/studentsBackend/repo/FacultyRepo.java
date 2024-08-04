package com.asarit.studentsBackend.repo;

import com.asarit.studentsBackend.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Long> {
}
