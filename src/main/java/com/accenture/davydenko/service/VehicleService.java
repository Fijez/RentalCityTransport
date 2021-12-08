package com.accenture.davydenko.service;

import com.accenture.davydenko.model.entity.Condition;
import com.accenture.davydenko.model.entity.VehicleEntity;

public class VehicleService {
    public static void repair(VehicleEntity vehicle) {
        vehicle.setCondition(Condition.GOOD);
    }

    public static void changeRentStatus(VehicleEntity vehicle) {
        vehicle.setIsRent(!vehicle.getIsRent());
    }
}