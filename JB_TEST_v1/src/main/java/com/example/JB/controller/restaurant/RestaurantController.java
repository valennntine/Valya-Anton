package com.example.JB.controller.restaurant;

import com.example.JB.model.Restaurant;
import com.example.JB.service.RestaurantService;
import com.example.JB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

//    private String userRole = SecurityContextHolder.getContext().getAuthentication().getName();




    @GetMapping
    public String main( Map<String, Object> model){
        Iterable<Restaurant> restaurants = restaurantService.findAll();
        String userRole = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).isAdmin();
        model.put("userRole",userRole);
        model.put("restaurants", restaurants);

        return "restaurant";
    }


    @GetMapping("find")
    public String find(@RequestParam(required = false, defaultValue ="")  String name, Model model){

        model.addAttribute("restaurants", restaurantService.findRestaurant(name));
        model.addAttribute("userRole", userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).isAdmin());
        model.addAttribute("name", name);


        return "restaurant";
    }


    @GetMapping("del")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String delete( @RequestParam("restaurantId") Restaurant restaurant, Model model){
        restaurantService.delete(restaurant);

        Iterable<Restaurant> restaurants = restaurantService.findAll();
        String userRole = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).isAdmin();
        model.addAttribute("userRole",userRole);
        model.addAttribute("restaurants", restaurants);
        return "restaurant";
    }

    @GetMapping("{restaurant}")
    public String restaurantEditForm(@PathVariable Restaurant restaurant, Model model){
        model.addAttribute("restaurant", restaurant);
        return "restaurantEdit";
    }

    @PostMapping("update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String restaurantSave(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String description,
            @RequestParam String phoneNumber,
            @RequestParam("restaurantId") Restaurant restaurant
    ){
        restaurantService.update(restaurant,name,address,description,phoneNumber);
        return "redirect:/restaurant";
    }

}
