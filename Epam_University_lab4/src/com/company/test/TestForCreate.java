package com.company.test;

import com.company.dbdao.*;
import com.company.exceptions.*;

public class TestForCreate {
    DaoUser daoUser = new DaoUser();
    DaoRestaurant daoRestaurant = new DaoRestaurant();
    DaoCafe daoCafe = new DaoCafe();
    DaoBook daoBook = new DaoBook();
    DaoAdmin daoAdmin = new DaoAdmin();


    public boolean testForUser(long id){
        try {
            daoUser.readUser(id);
            return false;
        }catch (UserNotFoundException e){
            return true;
        }
    }
    public boolean testForRestaurant(long id){
        try {
            daoRestaurant.readRestaurant(id);
            return false;
        }catch (RestaurantNotFoundException e){
            return true;
        }
    }
    public boolean testForCafe(long id){
        try {
            daoCafe.readCafe(id);
            return false;
        }catch (CafeNotFoundException e){
            return true;
        }
    }
    public boolean testForBook(long id){
        try {
            daoBook.readBook(id);
            return false;
        }catch (BookNotFoundException e){
            return true;
        }
    }
    public boolean testForAdmin(long id){
        try {
            daoAdmin.readAdmin(id);
            return false;
        }catch (AdminNotFoundException e){
            return true;
        }
    }
}
