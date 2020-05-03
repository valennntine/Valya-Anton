package com.company.dbdao;

import com.company.exceptions.UserNotFoundException;
import com.company.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class DaoUser {
    private final String USER = "MMF_9_13";
    private final String PASSWORD = "oracle";


    public static Logger log = LogManager.getLogger();
    private Connection connection;
    private Statement statement;
    private ResultSet response;

    public DaoUser() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e){
            log.fatal(e);
        }
    }

    public ArrayList<User> readAll() {
        String command = "SELECT * FROM USERS";
        ArrayList<User> Users = new ArrayList<>();
        try {
            response = statement.executeQuery(command);
            while (response.next()) {
                Users.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return Users;
    }

    public User readUser(long id) {
        try {
            response = statement.executeQuery("SELECT * FROM USERS WHERE id = " + id);
            if(response.next()) {
                return parseModel(response);
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        throw new UserNotFoundException();
    }
    public void deleteUser(long id) {
        String command = "DELETE FROM USERS WHERE id =" + id;
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public void updateUser(User user, long id) {
        this.deleteUser(id);
        this.createUser(user);
    }

    public void createUser(User user) {
        String command = "INSERT INTO USERS (id, email, password, usersname, phonenumber) VALUES ("+
                user.getId() +",'"+ user.getEmail() +"','"+ user.getPassword() +"','"+user.getUsername()+"','"+ user.getPhonenumber()+"')";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }
    public void deleteAll() {
        String command = "DELETE FROM USERS";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public User parseModel(ResultSet response) {
        try {
            long id = response.getLong("id");
            String email = response.getString("email").trim();
            String password = response.getString("password").trim();
            String username = response.getString("usersname").trim();
            String phonenumber = response.getString("phonenumber").trim();
            return new User(id, email, password,username,phonenumber);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }
}
