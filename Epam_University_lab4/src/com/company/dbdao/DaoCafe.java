package com.company.dbdao;

import com.company.exceptions.CafeNotFoundException;
import com.company.model.Cafe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class DaoCafe {
    private final String USER = "MMF_9_13";
    private final String PASSWORD = "oracle";


    public static Logger log = LogManager.getLogger();
    private Connection connection;
    private Statement statement;
    private ResultSet response;

    public DaoCafe() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e){
            log.fatal(e);
        }
    }

    public ArrayList<Cafe> readAll() {
        String command = "SELECT * FROM CAFES";
        ArrayList<Cafe> Cafes = new ArrayList<>();
        try {
            response = statement.executeQuery(command);
            while (response.next()) {
                Cafes.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return Cafes;
    }

    public Cafe readCafe(long id) {
        try {
            response = statement.executeQuery("SELECT * FROM CAFES WHERE id = " + id);
            if(response.next()) {
                return parseModel(response);
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        throw new CafeNotFoundException();
    }
    public void deleteCafe(long id) {
        String command = "DELETE FROM CAFES WHERE id =" + id;
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public void updateCafe(Cafe cafe, long id) {
        this.deleteCafe(id);
        this.createCafe(cafe);
    }

    public void createCafe(Cafe cafe) {
        String command = "INSERT INTO CAFES (id, name, address, phonenumber, avgbill) VALUES ("+
                cafe.getId() +",'"+ cafe.getName() +"','"+ cafe.getAddress() +"','"+cafe.getNumber()+"',"+ (float)cafe.getAvgbill()+")";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }
    public void deleteAll() {
        String command = "DELETE FROM CAFES";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public Cafe parseModel(ResultSet response) {
        try {
            long id = response.getLong("id");
            String name = response.getString("name").trim();
            String address = response.getString("address").trim();
            String phonenumber = response.getString("phonenumber").trim();
            double avgbill = response.getDouble("avgbill");
            return new Cafe(id, name,address,phonenumber,avgbill);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }
}
