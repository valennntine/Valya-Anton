import com.company.dao.DaoRestaurant;
import com.company.exceptions.RestaurantNotFoundException;
import com.company.model.Restaurant;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TestRestaurant {
    private final DaoRestaurant dao_Restaurant;

    public TestRestaurant() {
        dao_Restaurant = new DaoRestaurant();
    }

    @AfterEach
    public void clear() {
        dao_Restaurant.deleteRestaurant(0);
        dao_Restaurant.deleteRestaurant(1);
        System.err.println("After test");
    }

    @BeforeEach
    public void init() {
        dao_Restaurant.createRestaurant(new Restaurant(0, "", "", "", 1));
        dao_Restaurant.createRestaurant(new Restaurant(1, "", "2", "",0));
        System.err.println("Before test");
    }

    @Test
    public void testCreateRestaurant() {
        Assertions.assertEquals(dao_Restaurant.readRestaurant(0).getAvgbill(), 1);
    }

    @Test
    public void testDeleteRestaurant() {
        dao_Restaurant.deleteRestaurant(0);
        Assertions.assertThrows(RestaurantNotFoundException.class, () -> dao_Restaurant.readRestaurant(0));
    }

    @Test
    public void testReadRestaurant() {
        Assertions.assertEquals(dao_Restaurant.readRestaurant(1).getAvgbill(), 0);
    }

    @Test
    public void testReaddAllRestaurants(){
        ArrayList<Restaurant> Restaurants = dao_Restaurant.readAll();
        Assertions.assertEquals(Restaurants.get(1).getAvgbill(),0);
    }

    @Test
    public void testDeleteAllRestaurants()
    {
        dao_Restaurant.deleteAll();
        Assertions.assertThrows(RestaurantNotFoundException.class, () -> dao_Restaurant.readRestaurant(0));
        Assertions.assertThrows(RestaurantNotFoundException.class, () -> dao_Restaurant.readRestaurant(1));
    }
}
