package com.company.Checks;

import java.io.IOException;

public class TestGemView {
    public boolean test(String id ,String weight, String price, String visibility)
    {
        try{
            Long.parseLong(id);
            Double.parseDouble(weight);
            Double.parseDouble(price);
            Double.parseDouble(visibility);
            return true;

        }catch (NumberFormatException e) {
            System.out.println("Введены не корректные данные");
            return false;
        }
    }
    public boolean test(String id){
        try {
            Long.parseLong(id);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Введены не корректные данные");
            return false;
        }
    }
}
