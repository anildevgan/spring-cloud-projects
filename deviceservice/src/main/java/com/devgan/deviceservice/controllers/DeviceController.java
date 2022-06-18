package com.devgan.deviceservice.controllers;

import com.devgan.deviceservice.pojos.Device;
import com.devgan.deviceservice.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> devices(){
        return new ResponseEntity<>(deviceService.devices(), HttpStatus.OK);
    }

    @GetMapping("/devices/{deviceId}")
    public ResponseEntity<Device> deviceByDeviceId(@PathVariable("deviceId") String deviceId){
        return new ResponseEntity<>(deviceService.deviceById(deviceId), HttpStatus.OK);

    }
}
