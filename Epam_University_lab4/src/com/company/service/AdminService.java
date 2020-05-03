package com.company.service;


import com.company.exceptions.AdminNotFoundException;
import com.company.model.Admin;
import com.company.test.TestForCreate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class AdminService {
    Logger log = LogManager.getLogger();
    private com.company.dbdao.DaoAdmin daoAdmin = new com.company.dbdao.DaoAdmin();
    TestForCreate testForCreate = new TestForCreate();


    public void deleteAll()
    {
        daoAdmin.deleteAll();
    }

    public ArrayList<Admin> readAll(){
        return daoAdmin.readAll();
    }

    public Admin readAdmin(long id) {
        try {
            if (id >= 0) {
                daoAdmin.readAdmin(id);
                log.info("Админ возвращён");
                return daoAdmin.readAdmin(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (AdminNotFoundException e) {
            log.error("Данного админа не существует");
        }
        return null;
    }

    public void createAdmin(Admin admin) {
        /*try {
            daoAdmin.readAdmin(admin.getId());
            log.error("Админ с таким ID уже сущетсвует");

        } catch (AdminNotFoundException e) {
            if (admin.getEmail() != null && admin.getPassword() != null && admin.getId() >= 0) {
                daoAdmin.createAdmin(admin);
                log.info("Админ создан");
            } else {
                log.error("Введён отрицательный ID или данные введены не корректно");
            }
        }*/
        if(testForCreate.testForAdmin(admin.getId())){
            if (admin.getEmail() != null && admin.getPassword() != null && admin.getId() >= 0) {
                daoAdmin.createAdmin(admin);
                log.info("Админ создан");
            } else {
                log.error("Введён отрицательный ID или данные введены не корректно");
            }
        }else {
            log.error("Админ с таким ID уже сущетсвует");
        }
    }

    public void deleteAdmin(long id) {
        try {
            if (id >= 0) {
                daoAdmin.readAdmin(id);
                daoAdmin.deleteAdmin(id);
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
                daoAdmin.readAdmin(id);
                daoAdmin.updateAdmin(admin, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (AdminNotFoundException e) {
            log.error("Админа с таким id не существует");
        }
    }
}
