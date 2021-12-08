package com.accenture.davydenko.model.entity;

public class VehicleEntity {

    private int id;
    private TransportTypes transport;
    private Condition condition;
    private int parking_id;
    private double maxSpeed;
    private double energy;
    private boolean is_electric;
    private boolean isRent;

    public VehicleEntity(int id, TransportTypes transport,
                         Condition condition, int parking_id,
                         double maxSpeed, boolean is_electric) {
        this.id = id;
        this.transport = transport;
        this.condition = condition;
        this.parking_id = parking_id;
        this.maxSpeed = maxSpeed;
        this.is_electric = is_electric;
        isRent=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
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

    public boolean isIs_electric() {
        return is_electric;
    }

    public void setIs_electric(boolean is_electric) {
        this.is_electric = is_electric;
    }

    public boolean getIsRent() {
        return isRent;
    }

    public void setIsRent(boolean is_rent) {
        this.isRent= is_rent;
    }

}
