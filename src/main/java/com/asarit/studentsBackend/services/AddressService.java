package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    AddressDTO register(AddressDTO addressDTO);

    AddressDTO getById(Long addressId);

    List<AddressDTO> getAllAddress();


    void deleteById(Long id);

    AddressDTO updateAddress(AddressDTO addressDTO);

}
