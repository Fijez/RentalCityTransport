package com.davydenko.model.entity;


public interface UserEntity {

    public double getCash();

    public String getLogin();

    public String getPassword();

    public int getId();

    public String getFirst_name();

    public String getLast_name();

    public Access getAccess();

    public void setId(int id);

}
