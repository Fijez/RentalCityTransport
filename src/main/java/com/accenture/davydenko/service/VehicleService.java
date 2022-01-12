package com.accenture.davydenko.service;

import com.accenture.davydenko.model.entity.Condition;
import com.accenture.davydenko.model.entity.VehicleEntity;

@Component
public class VehicleService {
    public void repair(VehicleEntity vehicle) {
        vehicle.setCondition(Condition.GOOD);
    }

    public void changeRentStatus(VehicleEntity vehicle) {
        vehicle.setIsRent(!vehicle.getIsRent());
    }
}
