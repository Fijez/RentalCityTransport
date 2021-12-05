package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {

    private static final String USER = "fijez";
    private static final String PASSWORD = "forAccenture";
    private static final String URL = "jdbc:h2:tcp://localhost/~/CityRentalSystem";// +
            //System.getProperty("user.dir") +
           // "\\src\\main\\resources\\CityRentalSystem";

    public static Connection connectionToDB() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
            return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
