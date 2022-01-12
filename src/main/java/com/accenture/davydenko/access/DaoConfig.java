package com.accenture.davydenko.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//@Configuration
//@PropertySource("classpath:/application.properties")
//@ComponentScan
public class DaoConfig {

    //@Autowired
    private Environment env;

    //@Bean
    public MyDataSource dataSource() {
        MyDataSource dataSource = new MyDataSource();
            dataSource.setUrl(env.getProperty("db.url"));
            dataSource.setUser(env.getProperty("db.username"));
            dataSource.setPassword(env.getProperty("db.password"));
            return dataSource;
    }

    //@Bean
   public UserDao userDao() {
        return new UserDao(dataSource());
   }
}
