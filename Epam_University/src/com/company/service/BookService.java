package com.company.service;

import com.company.DAO.DAO_Book;
import com.company.exceptions.BookNotFoundException;
import com.company.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class BookService {
    Logger log = LogManager.getLogger();
    private DAO_Book dao_Book = new DAO_Book();

    public Book readBook(long id) {
        try {
            if (id >= 0) {
                dao_Book.readBook(id);
                log.info("Бронь возвращён");
                return dao_Book.readBook(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (BookNotFoundException e) {
            log.error("Данной брони не существует");
        }
        return null;
    }

    public void createBook(Book Book) {
        try {
            dao_Book.readBook(Book.getId());
            log.error("Бронь с таким ID уже сущетсвует");

        } catch (BookNotFoundException e) {
            if (Book.getCodeWord() != null && Book.getDateAndTime() != null && Book.getIdOfBook() >= 0 && Book.getNumberOfPeople()>0  && Book.getId() >= 0) {
                dao_Book.createBook(Book);
                log.info("Админ создан");
            } else {
                log.error("Введён отрицательный ID или данные введены не корректно");
            }
        }
    }

    public void deleteBook(long id) {
        try {
            if (id >= 0) {
                dao_Book.readBook(id);
                dao_Book.deleteBook(id);
                log.info("Бронь удалена");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (BookNotFoundException e) {
            log.error("Брони с таким ID не сужествует");
        }
    }

    public void updateBook(Book Book, long id) {
        try {
            if (Book.getCodeWord() != null && Book.getDateAndTime() != null && Book.getIdOfBook() >= 0 && Book.getNumberOfPeople()>0  && Book.getId() >= 0) {
                dao_Book.readBook(id);
                dao_Book.updateBook(Book, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (BookNotFoundException e) {
            log.error("Брони с таким id не существует");
        }
    }
}
