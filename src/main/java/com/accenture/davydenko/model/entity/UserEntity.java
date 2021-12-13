package com.accenture.davydenko.model.entity;

public class UserEntity {

    private int id;
    private String login;//e-mail
    private String password;
    private String first_name;
    private String last_name;
    private Access access;
    private double cash;
    Class<? extends VehicleEntity> transport;

    public UserEntity(int id, String login, String password,
                      String first_name, String last_name, double cash) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.access = Access.TENANT;
        this.cash = cash;
        transport = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", access=" + access +
                ", cash=" + cash +
                ", transport=" + transport +
                '}';
    }
}
