package com.company.Checks;

import com.company.Exceptions.DateOfGemIncorrect;

public class TestGemService {
    public void test(long id ,double weight, double price, double visibility, String name)
    {
        if( id < 0 || weight < 0 || price < 0 || visibility < 0 || name == null)
        {
            throw new DateOfGemIncorrect();
        }
    }
}
