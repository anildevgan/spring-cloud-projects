package com.devgan.vehicleservice.services;

import com.devgan.vehicleservice.pojos.Vehicle;
import com.devgan.vehicleservice.repos.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public List<Vehicle> vehicles(){
        return vehicleRepository.vehicles();
    }

    public Vehicle vehicleById(String deviceId){
        return vehicleRepository.vehicleById(deviceId);
    }


}
