package com.devgan.deviceservice.services;

import com.devgan.deviceservice.pojos.Device;
import com.devgan.deviceservice.repos.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public List<Device> devices(){
        return deviceRepository.devices();
    }

    public Device deviceById(String deviceId){
        return deviceRepository.deviceById(deviceId);
    }
}
