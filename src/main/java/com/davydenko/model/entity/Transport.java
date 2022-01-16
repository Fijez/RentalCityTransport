package com.davydenko.model.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {

    private static List<Transport> transportList = new ArrayList<>();

    double id;
    Condition condition;
    double maxSpeed;

    public static List<Transport> getTransportList() {
        return transportList;
    }

    public double getId() {
        return id;
    }

    public Class<? extends Transport> getTypeTransport() {
        return this.getClass();
    }

    public Condition getCondition() {
        return condition;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

}
