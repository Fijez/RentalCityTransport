package com.davydenko.access.UserDao;

import com.davydenko.access.DBconnection.ConnectionDB;
import com.davydenko.access.DaoConfiguration;
import com.davydenko.model.entity.AdminEntity;
import com.davydenko.model.entity.TenantEntity;
import com.davydenko.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class OperationsDB {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO user(first_name, last_name, email, password, role, cash)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String READ_USER_QUERY =
            "SELECT * FROM user WHERE email = ?";

    private static final String FIND_ALL_QUERY =
            "SELECT * FROM users";
    @Autowired
    private ConnectionDB connectionDB;
   @Autowired
    public OperationsDB() {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoConfiguration.class);
//        connectionDB = (ConnectionDB) applicationContext.getBean("connectionDB");
    }

    public UserEntity selectUserByLogin(String userLogin) {
      try(Connection connection = connectionDB.getConnection()) {
          PreparedStatement preparedStatement =
                  connection.prepareStatement(READ_USER_QUERY);
          preparedStatement.setString(1, userLogin);
          ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()) {
              //избавиться от if
              if (resultSet.getString("role").equals("admin")) {
                  UserEntity user = new AdminEntity(
                          resultSet.getString("email"),
                          resultSet.getString("password"),
                          resultSet.getString("first_name"),
                          resultSet.getString("last_name"),
                          resultSet.getDouble("cash"));
                  user.setId(resultSet.getInt("id"));
                  preparedStatement.close();
                  return user;
              } else if (resultSet.getString("role").equals("user")) {
                  UserEntity user = new TenantEntity(
                          resultSet.getString("email"),
                          resultSet.getString("password"),
                          resultSet.getString("first_name"),
                          resultSet.getString("last_name"),
                          resultSet.getDouble("cash"));
                  user.setId(resultSet.getInt("id"));
                  preparedStatement.close();
                  return user;
              }
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
    }
        return null;
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        try(Connection connection = connectionDB.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                UserEntity user = null;
                if (resultSet.getString("role") == "admin") {
                    user = new AdminEntity(
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDouble("cash"));
                } else
                if (resultSet.getString("role") == "user") {
                    user = new TenantEntity(//заменить на set, чтобы
                            //не дублировать код
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDouble("cash"));
                } else {
                    preparedStatement.close();
                    return null;
                }
                users.add(user);
                preparedStatement.close();
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public UserEntity createUser(UserEntity user) {
       //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoConfiguration.class);
        try (Connection connection = connectionDB.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(CREATE_USER_QUERY,
                            Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,user.getFirst_name());
            preparedStatement.setString(2,user.getLast_name());
            preparedStatement.setString(3,user.getLogin());
            preparedStatement.setString(4,user.getPassword());
            if (String.valueOf(user.getClass()).substring(6) == "Admin"){
                preparedStatement.setString(5, "admin");
            } else if (String.valueOf(user.getClass()).substring(6) == "user") {
                preparedStatement.setString(5, "user");
            }
            preparedStatement.setDouble(6, user.getCash());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
