package com.company.service;

import com.company.exceptions.UserNotFoundException;
import com.company.model.User;
import com.company.test.TestForCreate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class UserService {
    Logger log = LogManager.getLogger();
    private com.company.dbdao.DaoUser daoUser = new com.company.dbdao.DaoUser();
    TestForCreate testForCreate = new TestForCreate();

    public void deleteAll()
    {
        daoUser.deleteAll();
    }

    public ArrayList<User> readAll(){
        return daoUser.readAll();
    }

    public User readUser(long id) {
        try {
            if (id >= 0) {
                daoUser.readUser(id);
                log.info("Пользователь возвращён");
                return daoUser.readUser(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (UserNotFoundException e) {
            log.error("Данного Пользователя не существует");
        }
        return null;
    }

    public void createUser(User user) {
        /*
        try {
            daoUser.readUser(user.getId());
            log.error("Пользователь с таким ID уже сущетсвует");

        } catch (UserNotFoundException e) {
            if (user.getEmail() != null && user.getPassword() != null && user.getId() >= 0 &&
                    user.getUsername() != null && user.getPhonenumber() != null) {
                daoUser.createUser(user);
                log.info("Пользователь создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }*/
        if(testForCreate.testForUser(user.getId())){
            if (user.getEmail() != null && user.getPassword() != null && user.getId() >= 0 &&
                    user.getUsername() != null && user.getPhonenumber() != null) {
                daoUser.createUser(user);
                log.info("Пользователь создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }else{
            log.error("Пользователь с таким ID уже сущетсвует");
        }
    }

    public void deleteUser(long id) {
        try {
            if (id >= 0) {
                daoUser.readUser(id);
                daoUser.deleteUser(id);
                log.info("Пользователь удалён");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (UserNotFoundException e) {
            log.error("Пользовательа с таким ID не сужествует");
        }
    }

    public void updateUser(User user, long id) {
        try {
            if (user.getEmail() != null && user.getPassword() != null && user.getId() >= 0 &&
                    user.getUsername() != null && user.getPhonenumber() != null) {
                daoUser.readUser(id);
                daoUser.updateUser(user, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (UserNotFoundException e) {
            log.error("Пользователя с таким id не существует");
        }
    }
}
