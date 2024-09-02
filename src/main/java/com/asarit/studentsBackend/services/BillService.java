package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.BillDTO;

import java.util.List;

public interface BillService {
    BillDTO register(BillDTO billDTO);

    List<BillDTO> getAllBills();

    BillDTO getByBillId(Long billId);

    void deleteBill(Long id);

    BillDTO updateBill(BillDTO billDTO);

}
