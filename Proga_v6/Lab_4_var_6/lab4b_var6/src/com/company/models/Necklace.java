package com.company.models;

import java.util.ArrayList;

public class Necklace extends Gems {
    public Necklace(){
    }
    public ArrayList<Gem> getRange(double start, double end){
        ArrayList<Gem> temp = new ArrayList<Gem>();
        for (int i = 0; i<this.getCount(); i++){
            if (this.getGem(i).getVisibility()>= start && this.getGem(i).getVisibility()<= end){
                temp.add(this.getGem(i));
            }
        }
        return temp;
    }
    public void sortGems(){
        for (int i = 0; i<this.getCount()-1; i++){
            for (int j = 0; j<this.getCount()-i-1; j++){
                if (this.getGem(j).getPrice()>this.getGem(j+1).getPrice()){
                    Gem temp = new Gem();
                    temp = this.getGem(j+1);
                    this.setGem(this.getGem(j),j+1);
                    this.setGem(temp,j);
                }
            }
        }
    }
}
