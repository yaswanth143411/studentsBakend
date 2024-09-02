package com.asarit.studentsBackend.controller;

import com.asarit.studentsBackend.dto.BillDTO;
import com.asarit.studentsBackend.services.BillService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Bill")
public class BillController {
    private final BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/register")
    public ResponseEntity<BillDTO>register(@RequestBody BillDTO billDTO){
       return ResponseEntity.status(HttpStatus.CREATED).body(billService.register(billDTO));
    }

    @GetMapping("/getAllBills")
    public List<BillDTO> getAllBills(){
       return billService.getAllBills();
    }

    @GetMapping("/getById/{BillId}")
    public  ResponseEntity<BillDTO> getById(@PathVariable("BillId") Long BillId){
       return ResponseEntity.status(HttpStatus.FOUND).body(billService.getByBillId(BillId));
    }

    @DeleteMapping("/deleteBill/{id}")
    public String  deleteBill(@PathVariable("id") Long id){
        billService.deleteBill(id);
        return "Deleted Successfully";
    }

    @PutMapping("/updateBill")
    public ResponseEntity<BillDTO> updateBill(@RequestBody BillDTO billDTO){
       return ResponseEntity.status(HttpStatus.OK).body(billService.updateBill(billDTO));
    }

}
