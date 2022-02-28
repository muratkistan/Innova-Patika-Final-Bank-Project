package com.muratkistan.util.handler;


import com.muratkistan.util.ApiError;
import com.muratkistan.util.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map> handleNotfoundException(NotFoundException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors = new HashMap<>();
        ApiError error = new ApiError(400,"Validation Error","/users/add");
        for (FieldError fieldError :  exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }



}
