package com.asarit.studentsBackend.mapper;

import com.asarit.studentsBackend.dto.AddressDTO;
import com.asarit.studentsBackend.model.Address;
import com.asarit.studentsBackend.model.Student;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
    public Address toAddress(AddressDTO addressDTO, Student student){
       Address address=new Address();
               address.setId( addressDTO.getId());
               address.setDoorNo( addressDTO.getDoorNo());
              address.setStreet( addressDTO.getStreet());
               address.setVillage(addressDTO.getVillage());
              address.setMandal( addressDTO.getMandal());
              address.setDistrict(addressDTO.getDistrict());
              address.setState(  addressDTO.getState());
               address.setCountry(addressDTO.getCountry());
               address.setPinCode(addressDTO.getPinCode());
                address.setStudent(student);

        return address;
    }
    public AddressDTO toAddressDTO(Address address){
        return new AddressDTO(
                address.getId(),
                address.getDoorNo(),
                address.getStreet(),
                address.getVillage(),
                address.getMandal(),
                address.getDistrict(),
                address.getState(),
                address.getCountry(),
                address.getPinCode(),
                address.getStudent().getId()
        );
    }
}
