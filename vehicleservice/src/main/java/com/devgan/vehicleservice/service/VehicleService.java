package com.devgan.vehicleservice.service;

import com.devgan.vehicleservice.pojo.Device;
import com.devgan.vehicleservice.pojo.Vehicle;
import com.devgan.vehicleservice.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.HttpMethod;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Vehicle> vehicles(){

        List<Vehicle> vehicleList=new ArrayList<>();

        for (Vehicle vehicle:vehicleRepository.vehicles()){
            String url="http://deviceservice/devices/"+vehicle.getDevice().getDeviceId();
            ResponseEntity<Device> response = restTemplate.getForEntity(url,Device.class);
            Device device=response.getBody();
            vehicle.setDevice(device);
            vehicleList.add(vehicle);
        }
        return vehicleList;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
