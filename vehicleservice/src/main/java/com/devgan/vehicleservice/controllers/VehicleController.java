package com.devgan.vehicleservice.controllers;


import com.devgan.vehicleservice.pojos.Vehicle;
import com.devgan.vehicleservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> vehicles(){
        return vehicleService.vehicles();
    }
}
