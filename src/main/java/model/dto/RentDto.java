package model.dto;

import model.entity.ParkingEntity;
import model.entity.VehicleEntity;

import java.sql.Time;

public class RentDto {
    UserDto user;
    Time startRent;
    Time endRent;
    ParkingEntity startPoint;
    ParkingEntity endPoint;
    boolean rentStatus;
    Class <? extends VehicleEntity> transport;

    public RentDto(UserDto user, Time startRent, ParkingEntity startPoint,
                   Class<? extends VehicleEntity> transport) {
        this.user = user;
        this.startRent = startRent;
        this.startPoint = startPoint;
        this.rentStatus = true;
        this.transport = transport;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Time getStartRent() {
        return startRent;
    }

    public void setStartRent(Time startRent) {
        this.startRent = startRent;
    }

    public Time getEndRent() {
        return endRent;
    }

    public void setEndRent(Time endRent) {
        this.endRent = endRent;
    }

    public ParkingEntity getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(ParkingEntity startPoint) {
        this.startPoint = startPoint;
    }

    public ParkingEntity getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(ParkingEntity endPoint) {
        this.endPoint = endPoint;
    }

    public boolean isRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(boolean rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Class<? extends VehicleEntity> getTransport() {
        return transport;
    }

    public void setTransport(Class<? extends VehicleEntity> transport) {
        this.transport = transport;
    }
}
