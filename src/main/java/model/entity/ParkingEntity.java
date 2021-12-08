package model.entity;

import model.utils.Coordinates;

import java.util.List;

public class ParkingEntity {

    double id;
    Coordinates coordinates;
    double parkingRadius;
    transportTypes transportTypes;
    List<? extends Transport> transports;
    String address;


    public List<? extends Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<? extends Transport> transports) {
        this.transports = transports;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public double getParkingRadius() {
        return parkingRadius;
    }

    public void setParkingRadius(double parkingRadius) {
        this.parkingRadius = parkingRadius;
    }

    public model.entity.transportTypes getTransportTypes() {
        return transportTypes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTransportTypes(model.entity.transportTypes transportTypes) {
        this.transportTypes = transportTypes;
    }
}
