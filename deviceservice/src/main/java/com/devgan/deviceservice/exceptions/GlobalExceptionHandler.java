package com.devgan.deviceservice.exceptions;

import com.devgan.deviceservice.pojos.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeviceNotFoundException.class)
    ResponseEntity<ErrorMessage> handleDeviceNotFoundException(DeviceNotFoundException ex) {
        return new ResponseEntity<>(generateErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    private ErrorMessage generateErrorMessage(String message){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(message);
        return errorMessage;
    }

}
