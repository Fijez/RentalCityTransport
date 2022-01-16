package com.davydenko.access.DBconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class ConnectionDB {

    private static final String USER = "fijez";
    private static final String PASSWORD = "forAccenture";
    private static final String URL = "jdbc:h2:tcp://localhost/~/CityRentalSystem";// +
    private Connection connection;
            //System.getProperty("user.dir") +
           // "\\src\\main\\resources\\CityRentalSystem";
    @Autowired
    public ConnectionDB() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
//    public static Connection connectionToDB() throws SQLException {
//        DriverManager.registerDriver(new org.h2.Driver());
//            return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
}
