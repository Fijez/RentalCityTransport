package rent;

import transport.Transport;
import utils.parkingZones;

import java.sql.Time;

public class Rent {
    Class <? extends Transport> transport;
    Time startRent;
    Time endRent;
    parkingZones startPoint;
    parkingZones endPoint;
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

    public parkingZones getStartPoint() {
        return startPoint;
    }

    public parkingZones getEndPoint() {
        return endPoint;
    }

    public boolean isRent() {
        return rentStatus;
    }
}
