package com.asarit.studentsBackend.services;

import com.asarit.studentsBackend.dto.AddressDTO;
import com.asarit.studentsBackend.dto.CourseDTO;
import com.asarit.studentsBackend.dto.StudentDTO;
import com.asarit.studentsBackend.excepiton.AddressNotFoundException;
import com.asarit.studentsBackend.excepiton.StudentNotFoundException;
import com.asarit.studentsBackend.mapper.AddressMapper;
import com.asarit.studentsBackend.model.Address;
import com.asarit.studentsBackend.model.Course;
import com.asarit.studentsBackend.model.Student;
import com.asarit.studentsBackend.repo.AddressRepo;
import com.asarit.studentsBackend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServicelmp implements AddressService{
    private final AddressRepo addressRepo;
    private final AddressMapper addressMapper;
    private final StudentRepo studentRepo;


    public AddressServicelmp(AddressRepo addressRepo, AddressMapper addressMapper, StudentRepo studentRepo) {
        this.addressRepo = addressRepo;
        this.addressMapper = addressMapper;
        this.studentRepo = studentRepo;

    }


    @Override
    public AddressDTO register(AddressDTO addressDTO) {
        Optional<Student> studentFromDb=studentRepo.findById(addressDTO.getStudentId());
        if(studentFromDb.isEmpty()){
            throw new StudentNotFoundException("The given id with this"+addressDTO.getStudentId()+"is not found");

        }
        Student student=studentFromDb.get() ;
        Address address=addressMapper.toAddress(addressDTO,student);
        address.setStudent(studentRepo.findById(addressDTO.getStudentId()).get());

      return  addressMapper.toAddressDTO(addressRepo.save(address));

    }

    @Override
    public AddressDTO getById(Long addressId){
       Optional<Address> addressFromDb = addressRepo.findById(addressId);
       if(addressFromDb.isEmpty()) {
           throw new AddressNotFoundException("The given id with this"+addressId+"is not found");
       }

        return addressMapper.toAddressDTO(addressFromDb.get());
    }

    @Override
    public List<AddressDTO> getAllAddress() {
        List<Address> addressFromDb=addressRepo.findAll();
        List<AddressDTO> addressDTOS= new ArrayList<>();
        for (Address  address : addressFromDb) {
            AddressDTO addressDTO = addressMapper.toAddressDTO(address);
            addressDTOS.add(addressDTO);
        }
        return addressDTOS ;
    }

    @Override
    public void deleteById(Long id) {
       Optional<Address> addressDTO= addressRepo.findById(id);
       if(addressDTO.isEmpty()){
           throw new AddressNotFoundException("The given id with this"+id+"is not found");
       }
        addressRepo.deleteById(id);

    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {
       Optional<Student> studentFromDb=studentRepo.findById(addressDTO.getStudentId());
       if(studentFromDb.isEmpty()){
           throw new RuntimeException("the given id with this"+addressDTO.getStudentId());
       }
       Student student=studentFromDb.get();
       Address address=addressMapper.toAddress(addressDTO,student);
      addressRepo.save(address);
      return addressMapper.toAddressDTO(addressRepo.save(address));

    }


}
