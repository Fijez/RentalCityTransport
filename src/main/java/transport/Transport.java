package transport;

import utils.Condition;
import utils.parkingZones;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {

    private static List<Transport> transportList = new ArrayList<>();

    double id;
    Condition condition;
    parkingZones parkingZone;


    double maxSpeed;
    public static List<Transport> getTransportList() {
        return transportList;
    }

    public double getId() {
        return id;
    }

    public Class<? extends Transport> getTypesTransport() {
        return this.getClass();
    }

    public Condition getCondition() {
        return condition;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public parkingZones getParkingZone() {
        return parkingZone;
    }


}
