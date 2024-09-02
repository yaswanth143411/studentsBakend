package com.asarit.studentsBackend.excepiton;


public class BillNotFoundException extends RuntimeException{

    public BillNotFoundException(String message){
        super(message);
    }
}
