package com.company.models;
import java.util.List;

public class Aircraft {
    String name;
    int price;
    int capacity;
    List<Owner> stores;

    public List<Owner> getStores() {
        return stores;
    }

    public void setStores(List<Owner> stores) {
        this.stores = stores;
    }

    public Aircraft(String name, int price, int capacity) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.stores = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
