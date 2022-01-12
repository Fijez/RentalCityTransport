package com.accenture.davydenko.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Configuration
//@PropertySource("classpath:/application.properties")
//@ComponentScan
public class DBconnectionManager {
//    @Value("${db.url}")
//    private String jdbcUrl;
//   @Value("${db.username}")
//    private String jdbcUsername;
//   @Value("${db.password}")
//    private String jdbcPassword;
//   @Value("$db.driverClassName")
//   private String registerDriver;

//   @Autowired
    private Environment env;
    private static final String USER =  "fijez";
    private static final String PASSWORD = "forAccenture";
    private static final String URL = "jdbc:h2:tcp://localhost/~/CityRentalSystem";// +
//            System.getProperty("user.dir") +
//            "\\src\\main\\resources\\CityRentalSystem";

    private MyDataSource dataSource;

//    @Bean
    public MyDataSource dataSource(MyDataSource dataSource) {
        if (dataSource!=null) {
            dataSource.setUrl(env.getProperty("db.url"));
            dataSource.setUser(env.getProperty("db.username"));
            dataSource.setPassword(env.getProperty("db.password"));
            this.dataSource = dataSource;
        }
        return dataSource;
    }

    public static Connection connectionToDB() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
            return DriverManager.getConnection(URL,
                    USER, PASSWORD);
    }
}
