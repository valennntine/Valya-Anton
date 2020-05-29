package com.example.JB.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String name;

    private String address;

    private String description;


    private String phoneNumber;

    private int countOfPlaces;


    private String filename;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Book> booksOfRestaurant;


    public Set<Book> getBooksOfRestaurant() {
        return booksOfRestaurant;
    }

    public void setBooksOfRestaurant(Set<Book> books) {
        this.booksOfRestaurant = booksOfRestaurant;
    }

    public void addBookOfRestaurant(Book book){
        booksOfRestaurant.add(book);
    }

    public void deleteBookOfRestaurant(Book book){
        booksOfRestaurant.remove(book);
    }


    public int getCountOfPlaces() {
        return countOfPlaces;
    }

    public void setCountOfPlaces(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
    }

    public Restaurant() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
