package com.accenture.davydenko.model.entity;

import java.sql.Time;

public class RentEntity {
    int id;
    int userId;
    Time startRent;
    Time endRent;
    ParkingEntity startPoint;
    ParkingEntity endPoint;
    boolean rentStatus;
    Class <? extends VehicleEntity> transport;

    public RentEntity(int id, int userId, Time startRent,
                      ParkingEntity startPoint,
                      Class<? extends VehicleEntity> transport) {
        this.id = id;
        this.userId = userId;
        this.startRent = startRent;
        this.startPoint = startPoint;
        this.rentStatus = true;
        this.transport = transport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
