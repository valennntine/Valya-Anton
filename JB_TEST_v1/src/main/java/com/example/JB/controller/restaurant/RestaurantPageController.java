package com.example.JB.controller.restaurant;

import com.example.JB.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant/{name}")
public class RestaurantPageController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("page")
    public String main(
            @PathVariable("name") String name,
            Model model){
        model.addAttribute("restaurant", restaurantService.findByName(name));
        return "restaurantPage";
    }




}
