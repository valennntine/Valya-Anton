package com.company.DAO;

import com.company.exceptions.BookNotFoundException;
import com.company.model.Book;

import java.io.*;
import java.util.ArrayList;

public class DAO_Book {

    DAO_Restaurant dao_restaurant = new DAO_Restaurant();

    public Book readBook(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Book/BookBD.txt"))) {
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                long idOfRestaurant = Long.parseLong(reader.readLine());
                String dateAndTime = reader.readLine();
                int numberOfPeople = Integer.parseInt(reader.readLine());
                String codeWord = reader.readLine();
                if (id == Id) {
                    return new Book(dao_restaurant.readRestaurant(idOfRestaurant),Id,dateAndTime,numberOfPeople,codeWord);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new BookNotFoundException();
    }

    public void createBook(Book Book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Book/BookBD.txt", true))) {
            writer.write(Book.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }
    }
    public void deleteBook(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Book/BookBD.txt"));
             ) {
            ArrayList<Book> Books = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                long idOfRestaurant = Long.parseLong(reader.readLine());
                String dateAndTime = reader.readLine();
                int numberOfPeople = Integer.parseInt(reader.readLine());
                String codeWord = reader.readLine();
                Books.add(new Book(dao_restaurant.readRestaurant(idOfRestaurant),Id,dateAndTime,numberOfPeople,codeWord));
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Book/BookBD.txt"));
            Book Book;
            for (Book value : Books) {
                Book = value;
                if (Book.getId() != id) {
                    createBook(Book);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book Book, long id) {
        this.deleteBook(id);
        this.createBook(Book);
    }
}
