package com.devgan.vehicleservice.exceptions;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
