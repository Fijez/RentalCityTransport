package com.davydenko.model.entity;

import java.sql.Time;

public class RentEntity {
    Class <? extends Transport> transport;
    Time startRent;
    Time endRent;
    boolean rentStatus;

    public Class<? extends Transport> getTransport() {
        return transport;
    }

    public Time getStartRent() {
        return startRent;
    }

    public Time getEndRent() {
        return endRent;
    }

    public boolean isRent() {
        return rentStatus;
    }
}
