package com.devgan.deviceservice.controller;

import com.devgan.deviceservice.pojo.Device;
import com.devgan.deviceservice.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/devices")
    public List<Device> devices(){
        return deviceService.devices();
    }

    @GetMapping("/devices/{deviceId}")
    public Device deviceByDeviceId(@PathVariable("deviceId") String deviceId){
        return deviceService.deviceByDeviceId(deviceId);
    }
}
