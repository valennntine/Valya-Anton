package com.company.service;


import com.company.exceptions.RestaurantNotFoundException;
import com.company.model.Restaurant;
import com.company.test.TestForCreate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;

public class RestaurantService {
    Logger log = LogManager.getLogger();
    private com.company.dbdao.DaoRestaurant daoRestaurant = new com.company.dbdao.DaoRestaurant();
    TestForCreate testForCreate = new TestForCreate();

    public void deleteAll()
    {
        daoRestaurant.deleteAll();
    }

    public ArrayList<Restaurant> readAll(){
        return daoRestaurant.readAll();
    }

    public Restaurant readRestaurant(long id) {
        try {
            if (id >= 0) {
                daoRestaurant.readRestaurant(id);
                log.info("Ресторан возвращён");
                return daoRestaurant.readRestaurant(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (RestaurantNotFoundException e) {
            log.error("Данного Рестарана не существует");
        }
        return null;
    }

    public void createRestaurant(Restaurant restaurant) {
//        try {
//            daoRestaurant.readRestaurant(restaurant.getId());
//            log.error("Ресторан с таким ID уже сущетсвует");
//
//        } catch (RestaurantNotFoundException e) {
//            if (restaurant.getAddress() != null && restaurant.getName() != null && restaurant.getId() >= 0 &&
//                    restaurant.getNumber() != null && restaurant.getAvgbill() > 0 ) {
//                daoRestaurant.createRestaurant(restaurant);
//                log.info("Ресторан создан");
//            } else {
//                log.error("Введён отрицательный ID");
//            }
//        }
        if(testForCreate.testForRestaurant(restaurant.getId())){
            if (restaurant.getAddress() != null && restaurant.getName() != null && restaurant.getId() >= 0 &&
                    restaurant.getNumber() != null && restaurant.getAvgbill() > 0 ) {
                daoRestaurant.createRestaurant(restaurant);
                log.info("Ресторан создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }else {
            log.error("Ресторан с таким ID уже сущетсвует");
        }
    }

    public void deleteRestaurant(long id) {
        try {
            if (id >= 0) {
                daoRestaurant.readRestaurant(id);
                daoRestaurant.deleteRestaurant(id);
                log.info("Ресторан удалён");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (RestaurantNotFoundException e) {
            log.error("Ресторана с таким ID не сужествует");
        }
    }

    public void updateRestaurant(Restaurant restaurant, long id) {
        try {
            if (restaurant.getAddress() != null && restaurant.getName() != null && restaurant.getId() >= 0 &&
                    restaurant.getNumber() != null && restaurant.getAvgbill() > 0) {
                daoRestaurant.readRestaurant(id);
                daoRestaurant.updateRestaurant(restaurant, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (RestaurantNotFoundException e) {
            log.error("Рестарана с таким id не существует");
        }
    }
}
