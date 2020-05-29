package com.example.JB;

import com.example.JB.model.Cafe;
import com.example.JB.service.CafeService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class CafeServiceTest {

    @Autowired
    private CafeService cafeService;


    @Before
    public void before(){
        Cafe cafe = new Cafe();
        cafe.setText("1");
        cafe.setName("1");
        cafe.setDescription("1");
        cafe.setPhoneNumber("1");
        cafe.setGoogleMap("asdasdasdasd");
        cafeService.save(cafe);
    }

    @After
    public void after(){
        cafeService.delete(cafeService.find("1"));
    }


    @Test
    public void saveCafeTest(){
        Cafe cafe = new Cafe();
        cafe.setText("2");
        cafe.setName("2");
        cafe.setDescription("2");
        cafe.setPhoneNumber("2");
        cafeService.save(cafe);
        Assert.assertEquals(cafeService.find("2").getName(),"2");
        cafeService.delete(cafe);
    }

    @Test
    public void deleteCafeTest(){
        Cafe cafe = new Cafe();
        cafe.setText("2");
        cafe.setName("2");
        cafe.setDescription("2");
        cafe.setPhoneNumber("2");
        cafeService.save(cafe);
        Assert.assertEquals(cafeService.find("2").getName(),"2");
        cafeService.delete(cafe);
        Assert.assertNull(cafeService.find("2"));
    }

    @Test
    public void updateCafeTest(){
        cafeService.update(cafeService.find("1"),"1","2","2","2","googleMap");
        Assert.assertEquals(cafeService.find("1").getText(),"2");
    }

}
