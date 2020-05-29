package com.example.JB.controller.restaurant;

import com.example.JB.model.Restaurant;
import com.example.JB.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/restaurant/adder")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RestaurantAdderController {

    @Autowired
    private RestaurantService restaurantService;

    @Value("${upload.path}")
    private String uploadPath;



    @GetMapping
    public String main(){
        return "restaurantAdder";
    }

    @PostMapping("add")
    public String add(@RequestParam("file") MultipartFile file,
                      @RequestParam(required = false, defaultValue ="") String name ,
                      @RequestParam (required = false, defaultValue ="") String address,
                      @RequestParam (required = false, defaultValue ="") String description,
                      @RequestParam (required = false, defaultValue ="") String phoneNumber,
                      @RequestParam int countOfPlaces,
                      Map<String, Object> model) throws IOException {
        restaurantService.addRestaurant(file,name,address,description,phoneNumber,countOfPlaces, uploadPath);


        Iterable<Restaurant> restaurants = restaurantService.findAll();
        model.put("restaurants", restaurants);
        return "redirect:/restaurant";
    }
}
