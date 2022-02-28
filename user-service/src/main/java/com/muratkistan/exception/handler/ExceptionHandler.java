package com.muratkistan.exception.handler;

import com.muratkistan.util.ApiError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException exception){
        Map<String,String> validationErrors = new HashMap<>();
        validationErrors.put("identityNumber","User already exist");
        ApiError error = new ApiError(400,"User already exist","/users/add");

        error.setValidationErrors(validationErrors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
