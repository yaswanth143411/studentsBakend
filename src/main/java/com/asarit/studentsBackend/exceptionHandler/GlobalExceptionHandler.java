package com.asarit.studentsBackend.exceptionHandler;

import com.asarit.studentsBackend.excepiton.*;
import com.asarit.studentsBackend.model.Faculty;
import com.asarit.studentsBackend.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.asarit.studentsBackend.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCourseNotFoundException(CourseNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(), "the Customer Id does Not Exist");
        return new  ResponseEntity<>(errorResponse,HttpStatus.OK);
    }
    @ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBillNotFoundException(BillNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(), "the Customer Id does Not Exist");
        return new  ResponseEntity<>(errorResponse,HttpStatus.OK);
    }
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCourseNotFoundException(AddressNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(), "the Customer Id does Not Exist");
        return new  ResponseEntity<>(errorResponse,HttpStatus.OK);
    }
    @ExceptionHandler(FacultyNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFacultyNotFoundException(FacultyNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(), "the Customer Id does Not Exist");
        return new  ResponseEntity<>(errorResponse,HttpStatus.OK);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(), "the Customer Id does Not Exist");
        return new  ResponseEntity<>(errorResponse,HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>handleException(Exception e){
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(),"UnExcepted Error Occur");
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
