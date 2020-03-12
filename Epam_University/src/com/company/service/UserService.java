package com.company.service;

import com.company.DAO.DAO_User;
import com.company.exceptions.UserNotFoundException;
import com.company.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class UserService {
    Logger log = LogManager.getLogger();
    private DAO_User dao_User = new DAO_User();

    public void deleteAll()
    {
        dao_User.deleteAll();
    }

    public ArrayList<User> readAll(){
        return dao_User.readAll();
    }

    public User readUser(long id) {
        try {
            if (id >= 0) {
                dao_User.readUser(id);
                log.info("Пользователь возвращён");
                return dao_User.readUser(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (UserNotFoundException e) {
            log.error("Данного Пользователя не существует");
        }
        return null;
    }

    public void createUser(User User) {
        try {
            dao_User.readUser(User.getId());
            log.error("Пользователь с таким ID уже сущетсвует");

        } catch (UserNotFoundException e) {
            if (User.getEmail() != null && User.getPassword() != null && User.getId() >= 0 &&
                    User.getUsername() != null && User.getPhonenumber() != null) {
                dao_User.createUser(User);
                log.info("Пользователь создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }
    }

    public void deleteUser(long id) {
        try {
            if (id >= 0) {
                dao_User.readUser(id);
                dao_User.deleteUser(id);
                log.info("Пользователь удалён");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (UserNotFoundException e) {
            log.error("Пользовательа с таким ID не сужествует");
        }
    }

    public void updateUser(User User, long id) {
        try {
            if (User.getEmail() != null && User.getPassword() != null && User.getId() >= 0 &&
                    User.getUsername() != null && User.getPhonenumber() != null) {
                dao_User.readUser(id);
                dao_User.updateUser(User, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (UserNotFoundException e) {
            log.error("Пользователя с таким id не существует");
        }
    }
}
