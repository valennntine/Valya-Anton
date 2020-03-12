package com.company.service;

import com.company.DAO.DAO_Cafe;
import com.company.exceptions.CafeNotFoundException;
import com.company.model.Cafe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CafeService {
    Logger log = LogManager.getLogger();
    private DAO_Cafe dao_Cafe = new DAO_Cafe();

    public void deleteAll()
    {
        dao_Cafe.deleteAll();
    }

    public ArrayList<Cafe> readAll(){
        return dao_Cafe.readAll();
    }

    public Cafe readCafe(long id) {
        try {
            if (id >= 0) {
                dao_Cafe.readCafe(id);
                log.info("Кафе возвращено");
                return dao_Cafe.readCafe(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (CafeNotFoundException e) {
            log.error("Данного Кафе не существует");
        }
        return null;
    }

    public void createCafe(Cafe Cafe) {
        try {
            dao_Cafe.readCafe(Cafe.getId());
            log.error("Кафе с таким ID уже сущетсвует");

        } catch (CafeNotFoundException e) {
            if (Cafe.getAddress() != null && Cafe.getName() != null && Cafe.getId() >= 0 && Cafe.getNumber() != null && Cafe.getAvgbill() > 0) {
                dao_Cafe.createCafe(Cafe);
                log.info("Кафе создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }
    }

    public void deleteCafe(long id) {
        try {
            if (id >= 0) {
                dao_Cafe.readCafe(id);
                dao_Cafe.deleteCafe(id);
                log.info("Кафе удалён");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (CafeNotFoundException e) {
            log.error("Кафе с таким ID не сужествует");
        }
    }

    public void updateCafe(Cafe Cafe, long id) {
        try {
            if (Cafe.getAddress() != null && Cafe.getName() != null && Cafe.getId() >= 0 && Cafe.getNumber() != null
                    && Cafe.getAvgbill() > 0) {
                dao_Cafe.readCafe(id);
                dao_Cafe.updateCafe(Cafe, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (CafeNotFoundException e) {
            log.error("Кафеа с таким id не существует");
        }
    }
}
