/*package com.company.DAO;

import com.company.exceptions.BookingRNotFoundException;
import com.company.model.BookingR;
import com.company.model.Restaurant;

import java.io.*;
import java.util.ArrayList;

public class DAO_BookingR {

    DAO_Restaurant dao_restaurant;

    public BookingR readBookingR(long idOfBook, long idOfRestaurant) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/BookingR/BookingRBD.txt"))) {
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                long idOfPlace = Long.parseLong(reader.readLine());
                String dateAndTime = reader.readLine();
                int numberOfPeople = Integer.parseInt(reader.readLine());
                String codeWord = reader.readLine();
                Restaurant restaurant = dao_restaurant.readRestaurant(idOfRestaurant);
                if (idOfBook == Id && idOfRestaurant == restaurant.getId()) {
                    return new BookingR(restaurant,Id,idOfPlace,dateAndTime,numberOfPeople,codeWord);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new BookingRNotFoundException();
    }

    public void createBookingR(BookingR BookingR) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/BookingR/BookingRBD.txt", true))) {
            writer.write(BookingR.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }
    }
    public void deleteAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/BookingR/BookingRBD.txt"))) {
            writer.write("");
        } catch (IOException ignored) {
        }
    }

    public void deleteBookingR(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/BookingR/BookingRBD.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("BD/BookingR/BookingRBD.txt"))) {
            ArrayList<BookingR> BookingRs = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                long idOfPlace = Long.parseLong(reader.readLine());
                String dateAndTime = reader.readLine();
                int numberOfPeople = Integer.parseInt(reader.readLine());
                String codeWord = reader.readLine();
                BookingRs.add(new BookingR(Id,idOfPlace,dateAndTime,numberOfPeople,codeWord));
            }
            BookingR BookingR;
            for (BookingR value : BookingRs) {
                BookingR = value;
                if (BookingR.getId() != id) {
                    writer.write(BookingR.toString());
                    writer.newLine();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBookingR(BookingR BookingR, long id) {
        this.deleteBookingR(id);
        this.createBookingR(BookingR);
    }
}*/
