package com.devgan.deviceservice.repo;

import com.devgan.deviceservice.pojo.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DeviceRepository {

    public static List<Device> devices=new ArrayList<>();
    static{
        for(int i=1;i<=5;i++){
            Device device=new Device("Device"+i,"DeviceName"+i);
            devices.add(device);
        }
    }
    public List<Device> devices(){
        return devices;
    }

    public Device deviceByDeviceId(String deviceId){
        Optional<Device> deviceOptional = devices.stream()
                .filter(device -> device.getDeviceId()
                .equals(deviceId)).findFirst();
        return deviceOptional.isPresent()?deviceOptional.get():null;
    }



}
