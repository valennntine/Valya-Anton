package com.company;

import com.company.models.Aircraft;
import com.company.models.Owner;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AirCraftStream {
    Connection connection;
    public AirCraftStream(){
        connection = new Connection();
    }
    public boolean Check(){
        return connection.getAllAircfats().getAirCrafts().stream().anyMatch(x -> x.getCapacity() > 200);
    }

    public Aircraft getAirCraftsWithMaxCapacity()
    {
        return connection.getAllAircfats().getAirCrafts().stream().max(Comparator.comparing(Aircraft::getCapacity)).orElse(new Aircraft("NotFound", -1, -1));
    }
    public Aircraft getAirCraftsWithMinCapacity()
    {
        return connection.getAllAircfats().getAirCrafts().stream().min(Comparator.comparing(Aircraft::getCapacity)).orElse(new Aircraft("NotFound", -1, -1));
    }

    public List<Aircraft> getSortedByPrice(){
        return connection.getAllAircfats().getAirCrafts().stream().peek(x -> System.out.println("Sorting")).sorted(Comparator.comparing(Aircraft::getPrice)).collect(toList());
    }
    public List<Aircraft> getSortedByCapacity(){
        return connection.getAllAircfats().getAirCrafts().stream().peek(x -> System.out.println("Unsorted " + x)).sorted(Comparator.comparing(Aircraft::getCapacity)).collect(toList());
    }
    public List<Owner> getListOfOwners(){
        return connection.getAllAircfats().getAirCrafts().stream().flatMap(x -> x.getStores().stream()).collect(Collectors.toList());
    }

    public List<Owner> getListOfOwnersDistinct (){
        return connection.getAllAircfats().getAirCrafts().stream().flatMap(x -> x.getStores().stream()).distinct().collect(Collectors.toList());
    }
    public void printOwners(){
        connection.getAllOwners().getOwners().forEach(System.out::println);
    }

}
