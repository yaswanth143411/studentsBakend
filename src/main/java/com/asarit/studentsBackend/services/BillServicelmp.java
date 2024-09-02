package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.BillDTO;
import com.asarit.studentsBackend.excepiton.BillNotFoundException;
import com.asarit.studentsBackend.excepiton.StudentNotFoundException;
import com.asarit.studentsBackend.mapper.BillMapper;
import com.asarit.studentsBackend.model.Bill;
import com.asarit.studentsBackend.model.Student;
import com.asarit.studentsBackend.repo.BillRepo;
import com.asarit.studentsBackend.repo.StudentRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillServicelmp implements BillService{
    private final BillRepo billRepo;
    private final StudentRepo studentRepo;
    private final BillMapper billMapper;

    public BillServicelmp(BillRepo billRepo, StudentRepo studentRepo, BillMapper billMapper) {
        this.billRepo = billRepo;
        this.studentRepo = studentRepo;
        this.billMapper = billMapper;
    }

    @Override
    public BillDTO register(BillDTO billDTO) {
        Optional<Student> studentFromDb=studentRepo.findById(billDTO.getStudentId());
        if(studentFromDb.isEmpty()){
            throw new StudentNotFoundException("The given id with this"+billDTO.getStudentId()+"is not found");
        }
        Student student=studentFromDb.get();
        Bill bill=billRepo.save(billMapper.toBill(billDTO,student));

        return billMapper.toBillDTO(bill);
    }

    @Override
    public List<BillDTO> getAllBills() {
    List<Bill> billFromDb=billRepo.findAll();
    List<BillDTO> billDTOS=new ArrayList<>();
    for(Bill bill : billFromDb){
        BillDTO billDTO=billMapper.toBillDTO(bill);
        billDTOS.add(billDTO);
    }
        return billDTOS;
    }

    @Override
    public BillDTO getByBillId(Long billId) {
       Optional<Bill> optionalBill=billRepo.findById(billId);
        if(optionalBill.isEmpty()){
            throw new BillNotFoundException("The given Id with this"+billId+"is not found");
        }
         return billMapper.toBillDTO(optionalBill.get());

    }

    @Override
    public void deleteBill(Long id) {
        Optional<Bill> billfromDb=billRepo.findById(id);
        if(billfromDb.isEmpty()){
            throw new BillNotFoundException("The given id with this"+id+"is not found");
        }
        billRepo.deleteById(id);
    }

    @Override
    public BillDTO updateBill(BillDTO billDTO) {
        Optional<Bill> billFromDb=billRepo.findById(billDTO.getId());
        Optional<Student> studentFromDb=studentRepo.findById(billDTO.getStudentId());
        if(billFromDb.isEmpty()){
            throw new BillNotFoundException("The given Id with this"+billDTO.getId()+"is not found");
        }
        if(studentFromDb.isEmpty()){
            throw new StudentNotFoundException("The given Id with this"+billDTO.getStudentId()+"is not found");
        }
        Student student=studentFromDb.get();
        Bill bill=billMapper.toBill(billDTO,student);

       return billMapper.toBillDTO(billRepo.save(bill));
    }


}
