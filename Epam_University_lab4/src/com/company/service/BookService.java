package com.company.service;

import com.company.exceptions.BookNotFoundException;
import com.company.model.Book;
import com.company.test.TestForCreate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookService {
    Logger log = LogManager.getLogger();
    private com.company.dbdao.DaoBook daoBook = new com.company.dbdao.DaoBook();
    TestForCreate testForCreate = new TestForCreate();

    public Book readBook(long id) {
        try {
            if (id >= 0) {
                daoBook.readBook(id);
                log.info("Бронь возвращён");
                return daoBook.readBook(id);
            } else {
                log.warn("Введён отрицательный id");
            }
        } catch (BookNotFoundException e) {
            log.error("Данной брони не существует");
        }
        return null;
    }

    public void createBook(Book book) {
        /*try {
            daoBook.readBook(book.getId());
            log.error("Бронь с таким ID уже сущетсвует");

        } catch (BookNotFoundException e) {
            if (book.getCodeWord() != null && book.getDateAndTime() != null && book.getIdOfBook() >= 0 && book.getNumberOfPeople()>0  && book.getId() >= 0) {
                daoBook.createBook(book);
                log.info("Бронь создана");
            } else {
                log.error("Введён отрицательный ID или данные введены не корректно");
            }
        }*/
        if(testForCreate.testForBook(book.getIdOfBook())){
            if (book.getCodeWord() != null && book.getDateAndTime() != null && book.getIdOfBook() >= 0 && book.getNumberOfPeople()>0  && book.getId() >= 0) {
                daoBook.createBook(book);
                log.info("Бронь создана");
            } else {
                log.error("Введён отрицательный ID или данные введены не корректно");
            }
        }else{
            log.error("Бронь с таким ID уже сущетсвует");
        }
    }

    public void deleteBook(long id) {
        try {
            if (id >= 0) {
                daoBook.readBook(id);
                daoBook.deleteBook(id);
                log.info("Бронь удалена");
            } else {
                log.error("Введён отрицательный id");
            }
        } catch (BookNotFoundException e) {
            log.error("Брони с таким ID не сужествует");
        }
    }

    public void updateBook(Book book, long id) {
        try {
            if (book.getCodeWord() != null && book.getDateAndTime() != null && book.getIdOfBook() >= 0 && book.getNumberOfPeople()>0  && book.getId() >= 0) {
                daoBook.readBook(id);
                daoBook.updateBook(book, id);
            } else {
                log.error("Введён отрицательный id или данные введены не корректно");
            }

        } catch (BookNotFoundException e) {
            log.error("Брони с таким id не существует");
        }
    }
}
