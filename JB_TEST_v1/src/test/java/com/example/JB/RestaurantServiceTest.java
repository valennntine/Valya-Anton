package com.example.JB;

import com.example.JB.model.Restaurant;
import com.example.JB.service.RestaurantService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class RestaurantServiceTest {


    @Autowired
    private RestaurantService restaurantService;



    @Before
    public void addTestRestaurant() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setCountOfPlaces(1);
        restaurant1.setAddress("1");
        restaurant1.setName("1");
        restaurant1.setDescription("1");
        restaurant1.setPhoneNumber("1");
        restaurantService.save(restaurant1);
        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCountOfPlaces(2);
        restaurant2.setAddress("2");
        restaurant2.setName("2");
        restaurant2.setDescription("2");
        restaurant2.setPhoneNumber("2");
        restaurantService.save(restaurant2);
    }

    @After
    public void removeTestRestaurant(){
        restaurantService.delete(restaurantService.findByName("2"));
        restaurantService.delete(restaurantService.findByName("1"));
    }

    @Test
    public void findByName(){
        Assert.assertEquals(restaurantService.findByName("1").getName(),"1");
        Assert.assertNull(restaurantService.findByName("3"));
    }

    @Test
    public void saveTest(){
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCountOfPlaces(3);
        restaurant3.setAddress("3");
        restaurant3.setName("3");
        restaurant3.setDescription("3");
        restaurant3.setPhoneNumber("3");
        restaurantService.save(restaurant3);
        Assert.assertEquals(restaurantService.findByName("3").getName(),"3");
        restaurantService.delete(restaurantService.findByName("3"));
    }

    @Test
    public void deleteTest(){
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCountOfPlaces(3);
        restaurant3.setAddress("3");
        restaurant3.setName("3");
        restaurant3.setDescription("3");
        restaurant3.setPhoneNumber("3");
        restaurantService.save(restaurant3);
        Assert.assertEquals(restaurantService.findByName("3").getName(),"3");
        restaurantService.delete(restaurantService.findByName("3"));
        Assert.assertNull(restaurantService.findByName("3"));
    }

    @Test
    public void updateTest(){
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCountOfPlaces(3);
        restaurant3.setAddress("3");
        restaurant3.setName("3");
        restaurant3.setDescription("3");
        restaurant3.setPhoneNumber("3");
        restaurantService.save(restaurant3);
        Assert.assertEquals(restaurantService.findByName("3").getName(),"3");
        restaurantService.update(restaurant3, "4","3","3","3");
        Assert.assertEquals(restaurantService.findByName("4").getName(),"4");
        restaurantService.delete(restaurantService.findByName("4"));
        Assert.assertNull(restaurantService.findByName("4"));
    }

    @Test
    public void minusPlaceTest(){
        Assert.assertEquals(restaurantService.findByName("2").getCountOfPlaces(),2);
        restaurantService.minusPlace(restaurantService.findByName("2"));
        Assert.assertEquals(restaurantService.findByName("2").getCountOfPlaces(),1);
    }

    @Test
    public void plusPlaceTest(){
        Assert.assertEquals(restaurantService.findByName("2").getCountOfPlaces(),2);
        restaurantService.plusPlace(restaurantService.findByName("2"));
        Assert.assertEquals(restaurantService.findByName("2").getCountOfPlaces(),3);
    }

}
