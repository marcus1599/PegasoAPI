package com.example.Pegaso.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.Pegaso.exceptions.ExceptionResponse;
import com.example.Pegaso.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandle  extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) 
    {
        ExceptionResponse exceptionResponse= new ExceptionResponse(
            new Date(),ex.getMessage(),request.getDescription(false));
            
            return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request) 
    {
        ExceptionResponse exceptionResponse= new ExceptionResponse(
            new Date(),ex.getMessage(),request.getDescription(false));
            
            return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

    }
    
}
