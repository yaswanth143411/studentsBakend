package com.asarit.studentsBackend.repo;

import com.asarit.studentsBackend.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Long> {
}
