package com.company.Service;

import com.company.Checks.TestGemService;
import com.company.DAO.GemDao;
import com.company.Exceptions.DateOfGemIncorrect;
import com.company.Exceptions.GemNotFoundException;
import com.company.models.Gem;

import java.util.ArrayList;

public class GemService {
    private GemDao gemDao = new GemDao();
     private TestGemService testGemService = new TestGemService();

    public void deleteAll()
    {
        System.out.println();
        gemDao.deleteAll();
    }

    public ArrayList<Gem> readAll(){
        return gemDao.readAll();
    }

    public Gem readGem(long id) {
        try {
            if (id >= 0) {
                gemDao.readGem(id);
                System.out.println("Камень возвращён");
                return gemDao.readGem(id);
            } else {
                System.out.println("Введён отрицательный id");
            }
        } catch (GemNotFoundException e) {
            System.out.println("Данного камня не существует");
        }
        return null;
    }

    public void createGem(Gem Gem) {
        try {
            gemDao.readGem(Gem.getId());
            System.out.println("Камень с таким ID уже сущетсвует");

        } catch (GemNotFoundException e) {
            try {
                testGemService.test(Gem.getId(), Gem.getWeight(), Gem.getPrice(), Gem.getVisibility(), Gem.getName());
                gemDao.createGem(Gem);
                System.out.println("Камень создан");
            }catch (DateOfGemIncorrect a){
                System.out.println("Данные ввведены некорректо");
            }


        }
    }

    public void deleteGem(long id) {
        try {
            if (id >= 0) {
                gemDao.readGem(id);
                gemDao.deleteGem(id);
                System.out.println("Камень удалён");
            } else {
                System.out.println("Введён отрицательный id");
            }
        } catch (GemNotFoundException e) {
            System.out.println("Каменьа с таким ID не сужествует");
        }
    }

    public void updateGem(Gem Gem, long id) {
        try {
            try {
                testGemService.test(Gem.getId(),Gem.getWeight(),Gem.getPrice(),Gem.getVisibility(),Gem.getName());
                gemDao.readGem(id);
                gemDao.updateGem(Gem, id);

            }catch (DateOfGemIncorrect e) {
                System.out.println("Введены некорректные данные!");
            }

        } catch (GemNotFoundException e) {
            System.out.println("Камня с таким id не существует");
        }
    }
}
