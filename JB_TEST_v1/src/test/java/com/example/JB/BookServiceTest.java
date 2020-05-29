//package com.example.JB;
//
//import com.example.JB.model.Book;
//import com.example.JB.model.Restaurant;
//import com.example.JB.model.User;
//import com.example.JB.service.BooksService;
//import com.example.JB.service.RestaurantService;
//import com.example.JB.service.UserService;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestPropertySource("/application-test.properties")
//public class BookServiceTest {
//
//    @Autowired
//    private RestaurantService restaurantService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private BooksService booksService;
//
//    @Before
//    public void before(){
//        Restaurant restaurant1 = new Restaurant();
//        restaurant1.setCountOfPlaces(1);
//        restaurant1.setAddress("1");
//        restaurant1.setName("1");
//        restaurant1.setDescription("1");
//        restaurant1.setPhoneNumber("1");
//        restaurantService.save(restaurant1);
//        Book book = new Book();
//        book.setUser(userService.findByUsername("r"));
//        book.setRestaurant(restaurant1);
//        book.setTime("1");
//        book.setNumberOfPeople(1);
//        book.setCodeWord("1");
//        book.setPhoneNumber("1");
//        booksService.save(book);
//    }
//
//    @After
//    public void After(){
//        restaurantService.delete(restaurantService.findByName("1"));
//       booksService.delete(booksService.findAll().get(0));
//    }
//
//    @Test
//    public void findAll(){
//        Assert.assertEquals(booksService.findAll().get(0).getCodeWord(),"1");
//    }
//}
