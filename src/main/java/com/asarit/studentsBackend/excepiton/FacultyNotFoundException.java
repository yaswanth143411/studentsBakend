package com.asarit.studentsBackend.excepiton;


public class FacultyNotFoundException extends RuntimeException {
    public FacultyNotFoundException(String message){
        super(message);
    }
}
