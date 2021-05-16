package com.devgan.vehicleservice.controller;


import com.devgan.vehicleservice.pojo.Vehicle;
import com.devgan.vehicleservice.service.VehicleService;
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
