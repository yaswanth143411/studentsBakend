package com.asarit.studentsBackend.mapper;

import com.asarit.studentsBackend.dto.BillDTO;
import com.asarit.studentsBackend.model.Bill;
import com.asarit.studentsBackend.model.Student;
import org.springframework.stereotype.Service;

@Service
public class BillMapper {
    public Bill toBill(BillDTO billDTO, Student student){
        Bill bill=new Bill();
        bill.setId(billDTO.getId());
        bill.setAmount(billDTO.getAmount());
        bill.setPaymentDate(billDTO.getPaymentDate());
        bill.setStudent(student);
        return bill;
    }

    public BillDTO toBillDTO(Bill bill) {
       return new BillDTO(
               bill.getId(),
               bill.getPaymentDate(),
               bill.getAmount(),
               bill.getStudent().getId()
       );

    }
}
