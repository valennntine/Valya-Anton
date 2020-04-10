package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class AllAircfats {
    private List<Aircraft> airCrafts = new ArrayList<>();

    public AllAircfats()
    {
        airCrafts.add(new Aircraft("One", 150000, 150));
        airCrafts.add(new Aircraft("Two", 200000, 200));
        airCrafts.add(new Aircraft("Three", 2500000,250));
        airCrafts.add(new Aircraft("Four", 300000, 300));
        airCrafts.add(new Aircraft("Five", 350000,350));
    }

    public List<Aircraft> getAirCrafts(){
        return airCrafts;
    }

}
