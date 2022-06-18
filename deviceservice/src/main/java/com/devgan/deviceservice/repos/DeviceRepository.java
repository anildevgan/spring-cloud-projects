package com.devgan.deviceservice.repos;

import com.devgan.deviceservice.exceptions.DeviceNotFoundException;
import com.devgan.deviceservice.pojos.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.devgan.deviceservice.constants.Constants.DEVICE_NOT_FOUND;

@Repository
public class DeviceRepository {

    public static List<Device> devices=new ArrayList<>();
    static{
        for(int i=1;i<=5;i++){
            Device device=new Device(String.valueOf(i),"DeviceName"+i);
            devices.add(device);
        }
    }
    public List<Device> devices(){
        return devices;
    }

    public Device deviceById(String deviceId){
        Optional<Device> deviceOptional = devices.stream()
                .filter(device -> device.getDeviceId()
                .equals(deviceId)).findFirst();
        if (deviceOptional.isEmpty()){
            throw new DeviceNotFoundException(DEVICE_NOT_FOUND);
        }
        return deviceOptional.get();
    }



}
