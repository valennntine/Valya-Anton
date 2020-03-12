package com.company.service;

import com.company.DAO.DAO_Admin;
import com.company.exceptions.AdminNotFoundException;
import com.company.model.Admin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class AdminService {
    Logger log = LogManager.getLogger();
    private DAO_Admin dao_admin = new DAO_Admin();

    public void deleteAll()
    {
        dao_admin.deleteAll();
    }

    public ArrayList<Admin> readAll(){
        return dao_admin.readAll();
    }

    public Admin readAdmin(long id) {
        try {
            if (id >= 0) {
                dao_admin.readAdmin(id);
                log.info("Админ возвращён");
                return dao_admin.readAdmin(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (AdminNotFoundException e) {
            log.error("Данного админа не существует");
        }
        return null;
    }

    public void createAdmin(Admin admin) {
        try {
            dao_admin.readAdmin(admin.getId());
            log.error("Админ с таким ID уже сущетсвует");

        } catch (AdminNotFoundException e) {
            if (admin.getEmail() != null && admin.getPassword() != null && admin.getId() >= 0) {
                dao_admin.createAdmin(admin);
                log.info("Админ создан");
            } else {
                log.error("Введён отрицательный ID или данные введены не корректно");
            }
        }
    }

    public void deleteAdmin(long id) {
        try {
            if (id >= 0) {
                dao_admin.readAdmin(id);
                dao_admin.deleteAdmin(id);
                log.info("Админ удалён");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (AdminNotFoundException e) {
            log.error("Админа с таким ID не сужествует");
        }
    }

    public void updateAdmin(Admin admin, long id) {
        try {
            if (id >= 0 && admin.getEmail() != null && admin.getPassword() != null) {
                dao_admin.readAdmin(id);
                dao_admin.updateAdmin(admin, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (AdminNotFoundException e) {
            log.error("Админа с таким id не существует");
        }
    }
}
