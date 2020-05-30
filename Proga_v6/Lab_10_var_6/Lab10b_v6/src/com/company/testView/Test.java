package com.company.testView;

import com.sun.jdi.IntegerType;

public class Test {
    public boolean test(String menu){
        try {
            Integer.parseInt(menu);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Введите число!");
            return false;

        }

    }
}
