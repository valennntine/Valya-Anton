package com.company;

import com.company.models.Aircraft;
import com.company.models.AllAircfats;
import com.company.models.AllOwners;
import com.company.models.Owner;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    AllAircfats allAircfats;
    AllOwners allOwners;

    public Connection(){
        allAircfats = new AllAircfats();
        allOwners = new AllOwners();
        List<Owner> temp = new ArrayList<>();
        temp.add(allOwners.getOwners().get(0));
        temp.add(allOwners.getOwners().get(1));
        allAircfats.getAirCrafts().get(0).setStores(temp);
        temp.clear();
        temp.add(allOwners.getOwners().get(0));
        allAircfats.getAirCrafts().get(1).setStores(temp);
        temp.clear();
        temp.add(allOwners.getOwners().get(1));
        allAircfats.getAirCrafts().get(2).setStores(temp);
        temp.clear();
        temp.add(allOwners.getOwners().get(2));
        allAircfats.getAirCrafts().get(3).setStores(temp);
        temp.clear();
        temp.add(allOwners.getOwners().get(1));
        temp.add(allOwners.getOwners().get(2));
        allAircfats.getAirCrafts().get(4).setStores(temp);
        temp.clear();
        List<Aircraft> tempA = new ArrayList<>();
        tempA.add(allAircfats.getAirCrafts().get(0));
        tempA.add(allAircfats.getAirCrafts().get(1));
        allOwners.getOwners().get(0).setAircraftList(tempA);
        tempA.clear();
        tempA.add(allAircfats.getAirCrafts().get(0));
        tempA.add(allAircfats.getAirCrafts().get(2));
        tempA.add(allAircfats.getAirCrafts().get(4));
        allOwners.getOwners().get(1).setAircraftList(tempA);
        tempA.clear();
        tempA.add(allAircfats.getAirCrafts().get(3));
        tempA.add(allAircfats.getAirCrafts().get(4));
        allOwners.getOwners().get(2).setAircraftList(tempA);
        tempA.clear();
    }

    public AllAircfats getAllAircfats() {
        return allAircfats;
    }
    public AllOwners getAllOwners(){
        return allOwners;
    }
}
