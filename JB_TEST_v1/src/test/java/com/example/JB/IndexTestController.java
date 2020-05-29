package com.example.JB;


import com.example.JB.controller.restaurant.RestaurantController;
import com.example.JB.model.Restaurant;
import com.example.JB.service.RestaurantService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // Spring пытаеться автоматически создать структуру классов которая подменяет слой MVC

@TestPropertySource("/application-test.properties")
public class IndexTestController {
    @Autowired
    private RestaurantService restaurantService;



    @Autowired
    private MockMvc mockMvc;

    @Before
    public void before(){
        addTestRestaurant();
    }

    @After
    public void after(){
        removeTestRestaurant();
    }

    @WithUserDetails("r")
    @Test
    public void indexPageTest() throws Exception{
        this.mockMvc.perform(get("/restaurant"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/nav/div[2]").string("r"));
    }


    @WithUserDetails("r")
    @Test
    public void catalogOfRestaurantsTest() throws Exception{
        this.mockMvc.perform(get("/restaurant"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect((xpath("//*[@id=\"restaurant-list\"]/tbody/tr").nodeCount(2)));
    }

    @WithUserDetails("r")
    @Test
    public void filterCatalogOfRestaurantTest() throws Exception {
        this.mockMvc.perform(get("/restaurant/find").param("name","2"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id=\"restaurant-list\"]/tbody/tr").nodeCount(1));
    }

//    @Test
//    @WithUserDetails
//    public void addRestaurantTest() throws Exception {
//        MockMultipartHttpServletRequestBuilder multipart = (MockMultipartHttpServletRequestBuilder) multipart("/restaurant/adder/add")
//                .file("file", "2222".getBytes())
//                .param("name", "rest1")
//                .param("address", "3")
//                .param("description" , "4")
//                .param("phoneNumber", "4")
//                .param("countOfPlaces", "5")
//                .with(csrf());
//        this.mockMvc.perform(multipart)
//                .andDo(print())
//                .andExpect(authenticated())
//                .andExpect(xpath("//*[@id=\"restaurant-list\"]/tbody/tr").nodeCount(3));
//        restaurantService.delete(restaurantService.findByName("rest1"));
//    }


    private void addTestRestaurant() {
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
    private void removeTestRestaurant(){
        restaurantService.delete(restaurantService.findByName("2"));
        restaurantService.delete(restaurantService.findByName("1"));
    }
}
