package users;

import parking.Parking;
import transport.Transport;
import utils.Access;

public class Tenant implements User {

    private int id;
    private String login;//e-mail
    private String password;
    private final String first_name;
    private final String last_name;
    private final Access access;
    Class<? extends Transport> transport;

    private double cash;

    private Class<? extends Transport> rentedTransport;

    public Tenant(String login, String password, String first_name,
                  String last_name, Double cash) {
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.access = Access.READ;
        this.cash = cash;
    }


    public Class<? extends Transport> findUnoccupiedTransport(){
        return null;
    }

    public void rentTransport(Class<? extends Transport> transport, Parking parking) {

    }

    public void takeATripAndCloseRent() {

    }

    public double getBalance() {
        return cash;
    }


    public Class<? extends Transport> getRentedTransport() {
        return rentedTransport;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", access=" + access +
                ", transport=" + transport +
                ", cash=" + cash +
              //  ", rentedTransport=" + rentedTransport +
                '}';
    }

    @Override
    public double getCash() {
        return cash;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getFirst_name() {
        return this.first_name;
    }

    @Override
    public String getLast_name() {
        return this.last_name;
    }

    @Override
    public Access getAccess() {
        return this.access;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
