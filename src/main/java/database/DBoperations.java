package database;

import users.Admin;
import users.Tenant;
import users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBoperations {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO user(first_name, last_name, email, password, role, cash)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String READ_USER_QUERY =
            "SELECT * FROM user WHERE email = ?";

    private static final String FIND_ALL_QUERY =
            "SELECT * FROM users";

    public User createUser(User user) {
        try (Connection connection = DButils.connectionToDB()) {
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

    public static User selectUser(String userLogin) throws SQLException {
        try(Connection connection = DButils.connectionToDB()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(READ_USER_QUERY);
            preparedStatement.setString(1,userLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                //избавиться от if
                if (resultSet.getString("role").equals("admin")) {
                    User user = new Admin(
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDouble("cash"));
                    user.setId(resultSet.getInt("id"));
                    preparedStatement.close();
                    return user;
                } else
                    if (resultSet.getString("role").equals("user")) {
                        User user = new Tenant(
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
            preparedStatement.close();
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = DButils.connectionToDB()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                User user = null;
                if (resultSet.getString("role") == "admin") {
                    user = new Admin(
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDouble("cash"));
                } else
                if (resultSet.getString("role") == "user") {
                    user = new Tenant(//заменить на set, чтобы
                            //не дублировать код
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDouble("cash"));
                } else {
                    return null;
                }
                users.add(user);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
