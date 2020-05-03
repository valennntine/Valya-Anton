package com.company.dbdao;

import com.company.exceptions.BookNotFoundException;
import com.company.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DaoBook {
    private final String USER = "MMF_9_13";
    private final String PASSWORD = "oracle";
    private DaoRestaurant daoRestaurant = new DaoRestaurant();

    public static Logger log = LogManager.getLogger();
    private Connection connection;
    private Statement statement;
    private ResultSet response;

    public DaoBook() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e){
            log.fatal(e);
        }
    }

    public Book readBook(long id) {
        try {
            response = statement.executeQuery("SELECT * FROM BOOKS WHERE id = " + id);
            if(response.next()) {
                return parseModel(response);
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        throw new BookNotFoundException();
    }
    
    public void deleteAll() {
        String command = "DELETE FROM BOOKS";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public void deleteBook(long id) {
        String command = "DELETE FROM BOOKS WHERE id =" + id;
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public void updateBook(Book book, long id) {
        this.deleteBook(id);
        this.createBook(book);
    }

    public void createBook(Book book) {
        String command = "INSERT INTO BOOKS (idofbooks, id,dateandtime,phonenumberofpeople,codeword) VALUES ("+
                book.getIdOfBook() +","+ book.getId() +",'"+ book.getDateAndTime() +"',"+book.getNumberOfPeople()+",'"+ book.getCodeWord()+"')";
        try {
            statement.executeQuery(command);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }
    
    public Book parseModel(ResultSet response) {
        try {
            long idOfBooks = response.getLong("idofbooks");
            long id = response.getLong("id");
            String dateAndTime = response.getString("dateandtime").trim();
            int numberOfPeople = response.getInt("phonenumberofpeople");
            String avgbill = response.getString("codeword");
            return new Book(daoRestaurant.readRestaurant(id),idOfBooks,dateAndTime,numberOfPeople,avgbill);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }
}
