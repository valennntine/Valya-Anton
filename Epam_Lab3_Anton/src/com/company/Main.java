package com.company;

import com.company.models.Aircraft;
import com.company.models.Owner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        AirCraftStream airCraftStream = new AirCraftStream();
        System.out.println(airCraftStream.Check());
        System.out.println("Max - " + airCraftStream.getAirCraftsWithMaxCapacity());
        System.out.println("Min - " + airCraftStream.getAirCraftsWithMinCapacity());
        System.out.println(airCraftStream.getSortedByPrice());
        airCraftStream.printOwners();
	}
}
