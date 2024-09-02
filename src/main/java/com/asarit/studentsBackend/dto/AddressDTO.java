package com.asarit.studentsBackend.dto;

import com.asarit.studentsBackend.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
   private  Long id;
   private String doorNo;
   private  String street;
   private  String village;
   private String mandal;
   private  String district;
   private String state;
   private   String country;
   private Integer pinCode;
   private Long studentId;




}
