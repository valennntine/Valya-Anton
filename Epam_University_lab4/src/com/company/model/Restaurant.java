package com.company.model;

public class Restaurant {
    private long id;
    private String name;
    private String address;
    private String number;
    private double avgbill;

    public Restaurant(long id, String name, String address, String number, double avgbill) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.avgbill = avgbill;
    }

    public Restaurant(Restaurant restaurant) {
        this.id = restaurant.id;
        this.name = restaurant.name;
        this.address = restaurant.address;
        this.number = restaurant.number;
        this.avgbill = restaurant.avgbill;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getAvgbill() {
        return avgbill;
    }

    public void setAvgbill(double avgbill) {
        this.avgbill = avgbill;
    }

    @Override
    public String toString() {
        return id+"\n"+name+"\n"+address+ "\n" + number + "\n" + avgbill;
    }
}
