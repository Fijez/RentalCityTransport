package users;

import transport.Transport;
import utils.Access;

public class Admin implements User {
    private int id;
    private String login;//e-mail
    private String password;
    private final String first_name;
    private final String last_name;
    private final Access access;
    private double cash;
    Class<? extends Transport> transport;

    public Admin(String login, String password, String first_name,
                 String last_name, double cash) {
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.access = Access.FULL;
        this.cash = cash;
    }

    public void test() {

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
    public int getId() {
        return id;
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
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", access=" + access +
                ", cash=" + cash +
        //", transport=" + transport +
                '}';
    }
}
