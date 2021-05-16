package com.devgan.deviceservice.service;

import com.devgan.deviceservice.pojo.Device;
import com.devgan.deviceservice.repo.DeviceRepository;
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

    public Device deviceByDeviceId(String deviceId){
        return deviceRepository.deviceByDeviceId(deviceId);
    }
}
