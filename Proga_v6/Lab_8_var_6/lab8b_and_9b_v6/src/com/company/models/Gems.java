package com.company.models;

import java.util.ArrayList;

public class Gems {
    private ArrayList<Gem> gems;
    private double totalWeight;
    private double totalPrice;

    public void setGems(ArrayList<Gem> gems) {
        this.gems = gems;
        for (int i = 0 ; i < gems.size(); i++)
        {
            totalPrice += gems.get(i).getPrice();
            totalWeight += gems.get(i).getWeight();
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Gems() {
        gems = new ArrayList<Gem>();
        totalPrice = 0;
        totalWeight = 0;
    }
    public void addGem(Gem gem)
    {
        gems.add(gem);
        totalWeight += gem.getWeight();
        totalPrice +=gem.getPrice();
    }
    public void setGem(Gem gem, int index)
    {
        gems.set(index,gem);
    }
    public Gem getGem (int index){
        return gems.get(index);
    }
    public int getCount (){
        return gems.size();
    }

    @Override
    public String toString() {
        return "Gems{" +
                "gems=" + gems +
                ", totalWeight=" + totalWeight +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
