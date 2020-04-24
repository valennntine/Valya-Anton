package com.company;

import com.company.exceptions.AirCraftNotFound;
import com.company.models.Aircraft;
import com.company.models.AllAircfats;
import com.company.models.AllOwners;
import com.company.models.Owner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AirCraftStream {
    AllAircfats allAircfats;
    AllOwners allOwners;
    public AirCraftStream(){
        allAircfats = new AllAircfats();
        allOwners = new AllOwners();
        List<Owner> temp = new ArrayList<>();
        temp.add(allOwners.getOwners().get(0));
        temp.add(allOwners.getOwners().get(1));
        allAircfats.getAirCrafts().get(0).setStores(temp);
        temp.add(allOwners.getOwners().get(0));
        allAircfats.getAirCrafts().get(1).setStores(temp);
        temp.add(allOwners.getOwners().get(1));
        allAircfats.getAirCrafts().get(2).setStores(temp);
        temp.add(allOwners.getOwners().get(2));
        allAircfats.getAirCrafts().get(3).setStores(temp);
        temp.add(allOwners.getOwners().get(1));
        temp.add(allOwners.getOwners().get(2));
        allAircfats.getAirCrafts().get(4).setStores(temp);
        List<Aircraft> tempA = new ArrayList<>();
        tempA.add(allAircfats.getAirCrafts().get(0));
        tempA.add(allAircfats.getAirCrafts().get(1));
        allOwners.getOwners().get(0).setAircraftList(tempA);
        tempA.add(allAircfats.getAirCrafts().get(0));
        tempA.add(allAircfats.getAirCrafts().get(2));
        tempA.add(allAircfats.getAirCrafts().get(4));
        allOwners.getOwners().get(1).setAircraftList(tempA);
        tempA.add(allAircfats.getAirCrafts().get(3));
        tempA.add(allAircfats.getAirCrafts().get(4));
        allOwners.getOwners().get(2).setAircraftList(tempA);
    }
    public boolean check(){
        return allAircfats.getAirCrafts().stream().anyMatch(x -> x.getCapacity() > 200);
    }

    public Aircraft getAirCraftsWithMaxCapacity()
    {
        return allAircfats.getAirCrafts().stream().max(Comparator.comparing(Aircraft::getCapacity)).orElse(new Aircraft("NotFound", -1, -1));
    }
    public Aircraft getAirCraftsWithMinCapacity()
    {
        return allAircfats.getAirCrafts().stream().min(Comparator.comparing(Aircraft::getCapacity)).orElseThrow(AirCraftNotFound::new);
    }

    public List<Aircraft> getSortedByPrice(){
        return allAircfats.getAirCrafts().stream().peek(x -> System.out.println("Sorting")).sorted(Comparator.comparing(Aircraft::getPrice)).collect(toList());
    }
    public List<Aircraft> getSortedByCapacity(){
        return allAircfats.getAirCrafts().stream().peek(x -> System.out.println(" " + x)).sorted(Comparator.comparing(Aircraft::getCapacity)).collect(toList());
    }
    /*public List<Owner> getListOfOwners(){
        return allAircfats.getAirCrafts().stream().flatMap(x -> x.getStores().stream()).collect(Collectors.toList());
    }*/

    public List<Owner> getListOfOwnersDistinct (){

        return allAircfats.getAirCrafts().stream().flatMap(x -> x.getStores().stream()).distinct().collect(Collectors.toList());
    }
    public void printOwners(){
        allOwners.getOwners().stream().parallel().forEach(System.out::println);
        allOwners.getOwners().forEach(System.out::println);
    }

}
