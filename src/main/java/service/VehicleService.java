package service;

import model.entity.Condition;
import model.entity.VehicleEntity;

public class VehicleService {
    public static void repair(VehicleEntity vehicle) {
        vehicle.setCondition(Condition.GOOD);
    }

    public static void changeRentStatus(VehicleEntity vehicle) {
        vehicle.setIsRent(!vehicle.getIsRent());
    }
}
