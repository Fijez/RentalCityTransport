package com.accenture.davydenko.service;

import com.accenture.davydenko.service.ParkingService;
import com.accenture.davydenko.service.RentService;
import com.accenture.davydenko.service.UserService;
import com.accenture.davydenko.service.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    ParkingService parkingService() {
        System.out.println("parkingService bean");
        return new ParkingService();
    }
    @Bean
    RentService rentService() {
        System.out.println("rentService bean");
        return new RentService();
    }
    @Bean
    UserService userService() {
        System.out.println("userService bean");
        return new UserService();
    }
    @Bean
    VehicleService vehicleService() {
        System.out.println("vehicleService bean");
        return new VehicleService();
    }
}
