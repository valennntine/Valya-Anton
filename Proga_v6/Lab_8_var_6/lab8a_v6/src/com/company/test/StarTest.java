package com.company.test;

import com.company.exceptions.IncorrectDate;

public class StarTest {
    public boolean test(String name, String check){
        try {
            Boolean.parseBoolean(check);
            if(name != null && (check.equals("true") || check.equals("false"))){
                return true;
            }else {
                throw new IncorrectDate();
            }
        }catch (IncorrectDate e){
            System.out.println("Не верный формат данных");
            return false;
        }
    }
}
