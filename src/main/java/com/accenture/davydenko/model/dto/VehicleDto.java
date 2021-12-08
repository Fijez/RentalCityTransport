package com.accenture.davydenko.model.dto;

import com.accenture.davydenko.model.entity.Condition;
import com.accenture.davydenko.model.entity.TransportTypes;

public class VehicleDto {
    private TransportTypes transport;
    private Condition condition;
    private double maxSpeed;
    private double energy;
    boolean isElectric;
    boolean isRent;

    public VehicleDto(TransportTypes transport, Condition condition,
                      double maxSpeed, double energy,
                      boolean is_electric,boolean isRent) {
        this.transport = transport;
        this.condition = condition;
        this.maxSpeed = maxSpeed;
        this.energy = energy;
        this.isElectric = is_electric;
        this.isRent = isRent;
    }

    public TransportTypes getTransport() {
        return transport;
    }

    public void setTransport(TransportTypes transport) {
        this.transport = transport;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public boolean getIsElectric() {
        return isElectric;
    }

    public void setIsElectric(boolean is_electric) {
        this.isElectric = is_electric;
    }

    public boolean getIsRent() {
        return isRent;
    }

    public void setIsRent(boolean is_rent) {
        this.isRent= is_rent;
    }
}
