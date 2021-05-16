package com.devgan.vehicleservice.repo;


import com.devgan.vehicleservice.pojo.Device;
import com.devgan.vehicleservice.pojo.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {



    public List<Vehicle> vehicles(){
        List<Vehicle> vehicles=new ArrayList<>();
        for(int i=1;i<=5;i++){
            Device device=new Device();
            device.setDeviceId("Device"+i);
            Vehicle vehicle=new Vehicle("Car"+i,"Vin"+i,device);
            vehicles.add(vehicle);
        }
        return vehicles;
    }

}
