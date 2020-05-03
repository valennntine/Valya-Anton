package com.company.model;

import java.util.Objects;

public class Cafe {
    private long id;
    private String name;
    private String address;
    private String number;
    private double avgbill;

    public Cafe(long id, String name, String address, String number, double avgbill) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.avgbill = avgbill;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return id == cafe.id &&
                Double.compare(cafe.avgbill, avgbill) == 0 &&
                name.equals(cafe.name) &&
                address.equals(cafe.address) &&
                number.equals(cafe.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, number, avgbill);
    }

    @Override
    public String toString() {
        return id+"\n"+name+"\n"+address+ "\n" + number + "\n" + avgbill;
    }
}
