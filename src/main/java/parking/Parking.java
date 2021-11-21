package parking;

import transport.Transport;
import utils.Coordinates;
import utils.transportTypes;

import java.util.List;

public class Parking {

    List<? extends Transport> transports;

    double id;
    Coordinates coordinates;
    double parkingRadius;

    transportTypes transportTypes;
}
