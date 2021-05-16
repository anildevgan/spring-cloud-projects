package com.devgan.vehicleservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    private String vehicleName;
    private String vehicleId;
    private Device device;
}
