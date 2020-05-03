package com.company.service;

import com.company.exceptions.CafeNotFoundException;
import com.company.model.Cafe;
import com.company.test.TestForCreate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CafeService {
    Logger log = LogManager.getLogger();
    private com.company.dbdao.DaoCafe daoCafe = new com.company.dbdao.DaoCafe();
    TestForCreate testForCreate = new TestForCreate();

    public void deleteAll()
    {
        daoCafe.deleteAll();
    }

    public ArrayList<Cafe> readAll(){
        return daoCafe.readAll();
    }

    public Cafe readCafe(long id) {
        try {
            if (id >= 0) {
                daoCafe.readCafe(id);
                log.info("Кафе возвращено");
                return daoCafe.readCafe(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (CafeNotFoundException e) {
            log.error("Данного Кафе не существует");
        }
        return null;
    }

    public void createCafe(Cafe cafe) {
        /*try {
            daoCafe.readCafe(cafe.getId());
            log.error("Кафе с таким ID уже сущетсвует");

        } catch (CafeNotFoundException e) {
            if (cafe.getAddress() != null && cafe.getName() != null && cafe.getId() >= 0 && cafe.getNumber() != null && cafe.getAvgbill() > 0) {
                daoCafe.createCafe(cafe);
                log.info("Кафе создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }*/
        if(testForCreate.testForCafe(cafe.getId())){
            if (cafe.getAddress() != null && cafe.getName() != null && cafe.getId() >= 0 && cafe.getNumber() != null && cafe.getAvgbill() > 0) {
                daoCafe.createCafe(cafe);
                log.info("Кафе создан");
            } else {
                log.error("Введён отрицательный ID");
            }
        }else{
            log.error("Кафе с таким ID уже сущетсвует");
        }
    }

    public void deleteCafe(long id) {
        try {
            if (id >= 0) {
                daoCafe.readCafe(id);
                daoCafe.deleteCafe(id);
                log.info("Кафе удалён");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (CafeNotFoundException e) {
            log.error("Кафе с таким ID не сужествует");
        }
    }

    public void updateCafe(Cafe cafe, long id) {
        try {
            if (cafe.getAddress() != null && cafe.getName() != null && cafe.getId() >= 0 && cafe.getNumber() != null
                    && cafe.getAvgbill() > 0) {
                daoCafe.readCafe(id);
                daoCafe.updateCafe(cafe, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (CafeNotFoundException e) {
            log.error("Кафе с таким id не существует");
        }
    }
}
