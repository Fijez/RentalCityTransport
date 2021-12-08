package com.accenture.davydenko.model.dto;

import com.accenture.davydenko.model.entity.TransportTypes;
import com.accenture.davydenko.model.entity.VehicleEntity;

import java.util.List;

public class ParkingDto {
    String address;
    double parkingRadius;
    TransportTypes transportTypes;
    List<? extends VehicleEntity> transports;

    public ParkingDto(double parkingRadius, TransportTypes transportTypes,
                      List<? extends VehicleEntity> transports,
                      String address) {
        this.parkingRadius = parkingRadius;
        this.transportTypes = transportTypes;
        this.transports = transports;
        this.address = address;
    }

    public double getParkingRadius() {
        return parkingRadius;
    }

    public void setParkingRadius(double parkingRadius) {
        this.parkingRadius = parkingRadius;
    }

    public TransportTypes getTransportTypes() {
        return transportTypes;
    }

    public void setTransportTypes(TransportTypes transportTypes) {
        this.transportTypes = transportTypes;
    }

    public List<? extends VehicleEntity> getTransports() {
        return transports;
    }

    public void setTransports(List<? extends VehicleEntity> transports) {
        this.transports = transports;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
