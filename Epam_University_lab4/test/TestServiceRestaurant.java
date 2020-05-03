import com.company.dao.DaoRestaurant;
import com.company.model.Restaurant;
import com.company.service.RestaurantService;
import org.junit.jupiter.api.*;

public class TestServiceRestaurant {
    private final DaoRestaurant dao_Restaurant;
    private final RestaurantService RestaurantService;

    public TestServiceRestaurant() {
        dao_Restaurant = new DaoRestaurant();
        RestaurantService = new RestaurantService();
    }

    @AfterEach
    public void clear() {
        dao_Restaurant.deleteRestaurant(0);
        dao_Restaurant.deleteRestaurant(1);
        System.err.println("After test");
    }

    @BeforeEach
    public void init() {
        dao_Restaurant.createRestaurant(new Restaurant(0,"0", "0", "0", 0));
        dao_Restaurant.createRestaurant(new Restaurant(1, "1", "1", "1", 1));
        System.err.println("Before test");
    }

    @Test
    public void testReadRestaurant() {
        Assertions.assertEquals(RestaurantService.readRestaurant(0).getName(), "0");
        Assertions.assertNull(RestaurantService.readRestaurant(2));
        Assertions.assertNull(RestaurantService.readRestaurant(-1));
    }

    @Test
    public void testCreateRestaurant() {
        RestaurantService.createRestaurant(new Restaurant(2, null, " ","1", 1));
        Assertions.assertNull(RestaurantService.readRestaurant(2));
        RestaurantService.createRestaurant(new Restaurant(-2, " ", " ","1", 1));
        Assertions.assertNull(RestaurantService.readRestaurant(-2));
        RestaurantService.createRestaurant(new Restaurant(2, " ", " ","1", 1));
        Assertions.assertEquals(RestaurantService.readRestaurant(2).getName(), " ");
        dao_Restaurant.deleteRestaurant(2);
    }

    @Test
    public void testDeleteRestaurant() {
        RestaurantService.deleteRestaurant(-1);
        Assertions.assertEquals(RestaurantService.readRestaurant(1).getName(), "1");
        RestaurantService.deleteRestaurant(1);
        Assertions.assertNull(RestaurantService.readRestaurant(1));
    }

    @Test
    public void testUpdateRestaurant() {
        RestaurantService.updateRestaurant(new Restaurant(2, "2", null,"2", 2), 1);
        Assertions.assertNull(RestaurantService.readRestaurant(2));
        Assertions.assertEquals(RestaurantService.readRestaurant(1).getName(), "1");
        RestaurantService.updateRestaurant(new Restaurant(2, "2", "2","2",2), 1);
        Assertions.assertEquals(RestaurantService.readRestaurant(2).getName(), "2");
        Assertions.assertNull(RestaurantService.readRestaurant(1));
    }


}
