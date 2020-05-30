package com.company.models;

import java.util.Objects;

public class Car {
    private String model;
    private String number;
    private String colour;

    public Car(String model, String number, String colour) {
        this.model = model;
        this.number = number;
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public String getColour() {
        return colour;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) &&
                Objects.equals(number, car.number) &&
                Objects.equals(colour, car.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, number, colour);
    }

    @Override
    public String toString() {
            return "Car{" +
                "model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", colour='" + colour + '\'' +
                '}' +"\n";

    }
}
