package com.company.model;

import java.util.Objects;

public class Book extends Restaurant {
    private long idOfBook;
    private String dateAndTime;
    private int numberOfPeople;
    private String codeWord;

    public Book(long id, String name, String address, String number, double avgbill) {
        super(id, name, address, number, avgbill);
    }

    public Book(Restaurant restaurant) {
        super(restaurant);
    }

    public Book(long id, String name, String address, String number, double avgbill, long idOfBook, String dateAndTime, int numberOfPeople, String codeWord) {
        super(id, name, address, number, avgbill);
        this.idOfBook = idOfBook;
        this.dateAndTime = dateAndTime;
        this.numberOfPeople = numberOfPeople;
        this.codeWord = codeWord;
    }

    public Book(Restaurant restaurant, long idOfBook, String dateAndTime, int numberOfPeople, String codeWord) {
        super(restaurant);
        this.idOfBook = idOfBook;
        this.dateAndTime = dateAndTime;
        this.numberOfPeople = numberOfPeople;
        this.codeWord = codeWord;
    }

    @Override
    public String toString() {
        return  idOfBook +
                "\n"+  this.getId() +
                "\n" + dateAndTime +
                "\n" + numberOfPeople +
                "\n" + codeWord;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return idOfBook == book.idOfBook &&
                numberOfPeople == book.numberOfPeople &&
                Objects.equals(dateAndTime, book.dateAndTime) &&
                Objects.equals(codeWord, book.codeWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOfBook, dateAndTime, numberOfPeople, codeWord);
    }

    public long getIdOfBook() {
        return idOfBook;
    }

    public void setIdOfBook(long idOfBook) {
        this.idOfBook = idOfBook;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getCodeWord() {
        return codeWord;
    }

    public void setCodeWord(String codeWord) {
        this.codeWord = codeWord;
    }
}
