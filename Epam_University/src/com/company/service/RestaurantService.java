package com.company.service;

import com.company.DAO.DAO_Restaurant;
import com.company.exceptions.RestaurantNotFoundException;
import com.company.model.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class RestaurantService {
    Logger log = LogManager.getLogger();
    private DAO_Restaurant dao_Restaurant = new DAO_Restaurant();

    public void deleteAll()
    {
        dao_Restaurant.deleteAll();
    }

    public ArrayList<Restaurant> readAll(){
        return dao_Restaurant.readAll();
    }

    public Restaurant readRestaurant(long id) {
        try {
            if (id >= 0) {
                dao_Restaurant.readRestaurant(id);
                log.info("Ресторан возвращён");
                return dao_Restaurant.readRestaurant(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (RestaurantNotFoundException e) {
            log.error("Данного Пользователя не существует");
        }
        return null;
    }

    public void createRestaurant(Restaurant Restaurant) {
        try {
            dao_Restaurant.readRestaurant(Restaurant.getId());
            log.error("Ресторан с таким ID уже сущетсвует");

        } catch (RestaurantNotFoundException e) {
            if (Restaurant.getAddress() != null && Restaurant.getName() != null && Restaurant.getId() >= 0 &&
                    Restaurant.getNumber() != null && Restaurant.getAvgbill() > 0 ) {
                dao_Restaurant.createRestaurant(Restaurant);
                log.info("Ресторан создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }
    }

    public void deleteRestaurant(long id) {
        try {
            if (id >= 0) {
                dao_Restaurant.readRestaurant(id);
                dao_Restaurant.deleteRestaurant(id);
                log.info("Ресторан удалён");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (RestaurantNotFoundException e) {
            log.error("Ресторана с таким ID не сужествует");
        }
    }

    public void updateRestaurant(Restaurant Restaurant, long id) {
        try {
            if (Restaurant.getAddress() != null && Restaurant.getName() != null && Restaurant.getId() >= 0 &&
                    Restaurant.getNumber() != null && Restaurant.getAvgbill() > 0) {
                dao_Restaurant.readRestaurant(id);
                dao_Restaurant.updateRestaurant(Restaurant, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (RestaurantNotFoundException e) {
            log.error("Пользователя с таким id не существует");
        }
    }
}
