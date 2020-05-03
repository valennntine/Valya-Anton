package com.company.dbdao;

import com.company.exceptions.RestaurantNotFoundException;
import com.company.model.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class DaoRestaurant {
    private final String USER = "MMF_9_13";
    private final String PASSWORD = "oracle";


    public static Logger log = LogManager.getLogger();
    private Connection connection;
    private Statement statement;
    private ResultSet response;

    public DaoRestaurant() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e){
            log.fatal(e);
        }
    }

    public ArrayList<Restaurant> readAll() {
        String command = "SELECT * FROM RESTAURANTS";
        ArrayList<Restaurant> Restaurants = new ArrayList<>();
        try {
            response = statement.executeQuery(command);
            while (response.next()) {
                Restaurants.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return Restaurants;
    }

    public Restaurant readRestaurant(long id) {
        try {
            response = statement.executeQuery("SELECT * FROM RESTAURANTS WHERE id = " + id);
            if(response.next()) {
                return parseModel(response);
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        throw new RestaurantNotFoundException();
    }
    public void deleteRestaurant(long id) {
        String command = "DELETE FROM RESTAURANTS WHERE id =" + id;
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public void updateRestaurant(Restaurant restaurant, long id) {
        this.deleteRestaurant(id);
        this.createRestaurant(restaurant);
    }

    public void createRestaurant(Restaurant restaurant) {
        String command = "INSERT INTO RESTAURANTS (id, name, address, phonenumber, avgbill) VALUES ("+
                restaurant.getId() +",'"+ restaurant.getName() +"','"+ restaurant.getAddress() +"','"+restaurant.getNumber()+"',"+ (float)restaurant.getAvgbill()+")";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }
    public void deleteAll() {
        String command = "DELETE FROM RESTAURANTS";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public Restaurant parseModel(ResultSet response) {
        try {
            long id = response.getLong("id");
            String name = response.getString("name").trim();
            String address = response.getString("address").trim();
            String phonenumber = response.getString("phonenumber").trim();
            double avgbill = response.getDouble("avgbill");
            return new Restaurant(id, name,address,phonenumber,avgbill);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }
}
