package com.asarit.studentsBackend.excepiton;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String message){
        super(message);
    }
}
