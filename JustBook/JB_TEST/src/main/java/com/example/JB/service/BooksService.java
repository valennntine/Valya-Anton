package com.example.JB.service;

import com.example.JB.model.Book;
import com.example.JB.repos.BooksRepo;
import com.example.JB.repos.CafeRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private BooksRepo booksRepo;

    private Logger log = LogManager.getLogger();

    @Autowired
    public BooksService(@Qualifier("BooksDao") BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }


    public void save(Book book) {
        booksRepo.save(book);
        log.info("Book saved");
    }

    public Book findByIdOfBook(long bookId) {
        if(bookId > 0){
            log.info("Book found");
            return booksRepo.findByIdOfBook(bookId);

        }else{
            log.info("Book not found");
            return null;
        }
    }

    public void delete(Book book) {
        if(book != null){
            log.info("Book deleted");
            booksRepo.delete(book);
        }else{
            log.info("Book not deleted");
        }
    }

    public List<Book> findAll() {
        return (List<Book>) booksRepo.findAll();
    }
}
