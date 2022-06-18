package com.devgan.vehicleservice.exceptions;

import com.devgan.vehicleservice.pojos.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    ResponseEntity<ErrorMessage> handleVehicleNotFoundException(VehicleNotFoundException ex) {
        return new ResponseEntity<>(generateErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    private ErrorMessage generateErrorMessage(String message){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(message);
        return errorMessage;
    }

}
