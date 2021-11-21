package users;

import parking.Parking;
import transport.Transport;
import utils.Access;

public class Tenant extends Users {
    private double balance;
    private static final Access access = Access.READ;

    private Class<? extends Transport> rentedTransport;

    public Class<? extends Transport> getRentedTransport() {
        return rentedTransport;
    }

    public Class<? extends Transport> findUnoccupiedTransport(){
        return null;
    }

    public void rentTransport(Class<? extends Transport> transport, Parking parking) {

    }

    public void takeATripAndCloseRent() {

    }

    public double getBalance() {
        return balance;
    }

}
