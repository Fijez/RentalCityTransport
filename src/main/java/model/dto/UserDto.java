package model.dto;

import model.entity.Access;
import model.entity.VehicleEntity;

public class UserDto {
    private String login;//e-mail
    private String first_name;
    private String last_name;
    private Access access;
    private double cash;
    Class<? extends VehicleEntity> transport;

    public UserDto(String login, String first_name,
                   String last_name, Access access) {
        this.login = login;
        this.first_name = first_name;
        this.last_name = last_name;
        this.access = access;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Class<? extends VehicleEntity> getTransport() {
        return transport;
    }

    public void setTransport(Class<? extends VehicleEntity> transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", access=" + access +
                ", cash=" + cash +
                ", transport=" + transport +
                '}';
    }
}
