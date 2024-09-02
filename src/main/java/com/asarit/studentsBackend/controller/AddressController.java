package com.asarit.studentsBackend.controller;

import com.asarit.studentsBackend.dto.AddressDTO;
import com.asarit.studentsBackend.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address/")
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("register")
    public ResponseEntity<AddressDTO> register(@RequestBody AddressDTO addressDTO){

        return ResponseEntity.status(HttpStatus.OK).body(addressService.register(addressDTO));

    }

    @GetMapping("/getById/{addressId}")
    public ResponseEntity<AddressDTO> getById(@PathVariable("addressId") Long addressId){
       return ResponseEntity.status(HttpStatus.OK).body( addressService.getById(addressId));
    }

    @GetMapping("/getAllAddress")
    public List<AddressDTO>getAllAddress(){
       return  addressService.getAllAddress();
    }
    @DeleteMapping("/deleteById/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable("Id") Long Id){
       addressService.deleteById(Id);
       return  ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
    @PutMapping("update")
    public ResponseEntity<AddressDTO>  update(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(addressDTO));

    }
}
