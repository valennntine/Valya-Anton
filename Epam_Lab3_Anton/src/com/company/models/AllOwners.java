package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class AllOwners {
    private List<Owner> owners = new ArrayList<>();

    public AllOwners()
    {
        owners.add(new Owner("BelAirwaves", "Belarus"));
        owners.add(new Owner("RenAir", "Poland"));
        owners.add(new Owner("WizAir", "Germany"));
    }

    public List<Owner> getOwners(){
        return owners;
    }
}
