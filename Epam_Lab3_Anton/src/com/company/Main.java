package com.company;

public class Main {

    public static void main(String[] args) {
        AirCraftStream airCraftStream = new AirCraftStream();
        System.out.println(airCraftStream.check());
        System.out.println("Max - " + airCraftStream.getAirCraftsWithMaxCapacity());
        System.out.println("Min - " + airCraftStream.getAirCraftsWithMinCapacity());
        System.out.println(airCraftStream.getSortedByPrice());
        System.out.println(airCraftStream.getSortedByCapacity());
        //System.out.println(airCraftStream.getListOfOwners());
        System.out.println(airCraftStream.getListOfOwnersDistinct());
        airCraftStream.printOwners();
    }
}
