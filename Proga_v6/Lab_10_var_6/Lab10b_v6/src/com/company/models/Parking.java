package com.company.models;

import com.company.exceptions.OutOfListException;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    List<Car> parking;

    public Parking(int n) {
        parking = new ArrayList<Car>();
        for (int i = 0 ; i < n; i ++){
            parking.add(null);
        }

    }
    public void setPlace(int index, Car car){
        if(!(index < 0 || index >= parking.size())){
            parking.set(index,car);
        }else {
            throw new OutOfListException();
        }
    }

    public void setPlace(Car car){
        int n = 0;
        while(!(parking.get(n)==null)){
            n++;
        }
        if( n == parking.size()-1){
            System.out.println("Все места заняты");
        }else {
            parking.set(n,car);
        }
    }

    public Car getCar(int index){
        if(!(index < 0 || index >= parking.size())) {
            return parking.get(index);
        }else{
            throw new OutOfListException();
        }
    }

    public void deleteCar(int index){
        if(!(index < 0 || index >= parking.size())) {
            parking.set(index,null);
        }else{
            throw new OutOfListException();
        }
    }
    public void deleteAll(){
        for (int i = 0 ; i < parking.size(); i ++){
            parking.set(i,null);
        }
    }

    @Override
    public String toString() {
        return  "{"+ parking + "}";
    }
}
