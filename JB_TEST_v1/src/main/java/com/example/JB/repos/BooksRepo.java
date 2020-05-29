package com.example.JB.repos;

import com.example.JB.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("BooksDao")
public interface BooksRepo extends CrudRepository<Book,Long> {

    //Book findByCodeWordAndTimeAndPhoneNumber(String codeWord, String dateAndTime, String phoneNumber);

    Book findByIdOfBook(long id);

//    Book findTopByCodeWord(String codeWord);
//
//    Book findByCodeWordAndTimeAndPhoneNumber(String codeWord, String Time, String phoneNumber);
}
