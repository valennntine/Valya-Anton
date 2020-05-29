package com.example.JB;


import com.example.JB.controller.cafe.CafeController;
import com.example.JB.model.Cafe;
import com.example.JB.service.CafeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // Spring пытаеться автоматически создать структуру классов которая подменяет слой MVC

@TestPropertySource("/application-test.properties")
public class CafeTestController {
    @Autowired
    private CafeService cafeService;



    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CafeController controller;

    @Before
    public void before(){
        addTestCafe();
    }

    @After
    public void after(){
        removeTestCafe();
    }

    @WithUserDetails("r")
    @Test
    public void indexPageTest() throws Exception{
        this.mockMvc.perform(get("/cafe"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/nav/div[2]").string("r"));
    }


    @WithUserDetails("r")
    @Test
    public void catalogOfCafesTest() throws Exception{
        this.mockMvc.perform(get("/cafe"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect((xpath("//*[@id=\"cafe-list\"]/tbody/tr").nodeCount(2)));
    }

    @WithUserDetails("r")
    @Test
    public void filterCatalogOfCafeTest() throws Exception {
        this.mockMvc.perform(get("/cafe/find").param("name","2"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id=\"cafe-list\"]/tbody/tr").nodeCount(1));
    }

//    @Test
//    @WithUserDetails
//    public void addCafeTest() throws Exception {
//        MockMultipartHttpServletRequestBuilder multipart = (MockMultipartHttpServletRequestBuilder) multipart("/cafe/adder/add")
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
//                .andExpect(xpath("//*[@id=\"cafe-list\"]/tbody/tr").nodeCount(3));
//        cafeService.delete(cafeService.findByName("rest1"));
//    }


    private void addTestCafe() {
        Cafe cafe1 = new Cafe();
        cafe1.setText("1");
        cafe1.setName("1");
        cafe1.setDescription("1");
        cafe1.setPhoneNumber("1");
        cafeService.save(cafe1);
        Cafe cafe2 = new Cafe();
        cafe2.setText("2");
        cafe2.setName("2");
        cafe2.setDescription("2");
        cafe2.setPhoneNumber("2");
        cafeService.save(cafe2);
    }
    private void removeTestCafe(){
        cafeService.delete(cafeService.find("2"));
        cafeService.delete(cafeService.find("1"));
    }
}
