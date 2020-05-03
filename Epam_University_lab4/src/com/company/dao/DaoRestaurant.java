package com.company.dao;

import com.company.exceptions.RestaurantNotFoundException;
import com.company.model.Restaurant;

import java.io.*;
import java.util.ArrayList;

public class DaoRestaurant {

    public ArrayList<Restaurant> readAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Restaurant/RestaurantBD.txt"))) {
            ArrayList<Restaurant> Restaurants = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String name = reader.readLine();
                String address = reader.readLine();
                String phone = reader.readLine();
                double avgbill = Double.parseDouble(reader.readLine());
                Restaurants.add(new Restaurant(Id,name,address,phone,avgbill));
            }
            return Restaurants;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Restaurant readRestaurant(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Restaurant/RestaurantBD.txt"))) {
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String name = reader.readLine();
                String address = reader.readLine();
                String phone = reader.readLine();
                double avgbill = Double.parseDouble(reader.readLine());
                if (id == Id) {
                    return new Restaurant(Id,name,address,phone,avgbill);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RestaurantNotFoundException();
    }

    public void createRestaurant(Restaurant Restaurant) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Restaurant/RestaurantBD.txt", true))) {
            writer.write(Restaurant.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }
    }
    public void deleteAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Restaurant/RestaurantBD.txt"))) {
            writer.write("");
        } catch (IOException ignored) {
        }
    }

    public void deleteRestaurant(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Restaurant/RestaurantBD.txt"));
             ) {
            ArrayList<Restaurant> Restaurants = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String name = reader.readLine();
                String address = reader.readLine();
                String phone = reader.readLine();
                double avgbill = Double.parseDouble(reader.readLine());
                Restaurants.add(new Restaurant(Id,name,address,phone,avgbill));
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Restaurant/RestaurantBD.txt"));
            Restaurant Restaurant;
            for (Restaurant value : Restaurants) {
                Restaurant = value;
                if (Restaurant.getId() != id) {
                    createRestaurant(Restaurant);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateRestaurant(Restaurant Restaurant, long id) {
        this.deleteRestaurant(id);
        this.createRestaurant(Restaurant);
    }
}
