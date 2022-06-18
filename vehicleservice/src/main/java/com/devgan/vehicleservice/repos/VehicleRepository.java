package com.devgan.vehicleservice.repos;


import com.devgan.vehicleservice.exceptions.VehicleNotFoundException;
import com.devgan.vehicleservice.pojos.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.devgan.vehicleservice.constants.Constants.VEHICLE_NOT_FOUND;

@Repository
public class VehicleRepository {

    public static List<Vehicle> vehicles=new ArrayList<>();
    static{
        for(int i=1;i<=5;i++){
            Vehicle vehicle=new Vehicle(String.valueOf(i),"Vehicle"+i);
            vehicles.add(vehicle);
        }
    }
    public List<Vehicle> vehicles(){
        return vehicles;
    }

    public Vehicle vehicleById(String vehicleId){
        Optional<Vehicle> vehicleOptional= vehicles.stream()
                .filter(vehicle -> vehicle.getVehicleId()
                        .equals(vehicleId)).findFirst();
        if (vehicleOptional.isEmpty()){
            throw new VehicleNotFoundException(VEHICLE_NOT_FOUND);
        }
        return vehicleOptional.get();
    }

}
