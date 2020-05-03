package com.company.dbdao;

import com.company.exceptions.AdminNotFoundException;
import com.company.model.Admin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class DaoAdmin {
    private final String USER = "MMF_9_13";
    private final String PASSWORD = "oracle";


    public static Logger log = LogManager.getLogger();
    private Connection connection;
    private Statement statement;
    private ResultSet response;

    public DaoAdmin() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e){
            log.fatal(e);
        }
    }

    public ArrayList<Admin> readAll() {
        String command = "SELECT * FROM ADMINS";
        ArrayList<Admin> Admins = new ArrayList<>();
        try {
            response = statement.executeQuery(command);
            while (response.next()) {
                Admins.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return Admins;
    }

    public Admin readAdmin(long id) {
        try {
            response = statement.executeQuery("SELECT * FROM ADMINS WHERE id = " + id);
            if(response.next()) {
                return parseModel(response);
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        throw new AdminNotFoundException();
    }
    public void deleteAdmin(long id) {
        String command = "DELETE FROM ADMINS WHERE id =" + id;
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public void updateAdmin(Admin admin, long id) {
        this.deleteAdmin(id);
        this.createAdmin(admin);
    }

    public void createAdmin(Admin admin) {
        String command = "INSERT INTO ADMINS (id, email, password) VALUES ("+ admin.getId() +",'"+ admin.getEmail() +"','"+ admin.getPassword() +"')";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }
    public void deleteAll() {
        String command = "DELETE FROM ADMINS";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public Admin parseModel(ResultSet response) {
        try {
            long id = response.getLong("id");
            String email = response.getString("email").trim();
            String password = response.getString("password").trim();
            return new Admin(id, email, password);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }
}
