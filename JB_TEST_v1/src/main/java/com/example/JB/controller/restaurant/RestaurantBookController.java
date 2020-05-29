package com.example.JB.controller.restaurant;

import com.example.JB.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/restaurant/{name}")
public class RestaurantBookController {
    @Autowired
    RestaurantService restaurantService;


    @GetMapping("Book")
    public String main(
            @PathVariable("name") String name,
            Model model){
        model.addAttribute("restaurant", restaurantService.findByName(name));
        return "restaurantBook";
    }

    @PostMapping("addBook")
    public String addBook(@RequestParam long id,
                          @RequestParam String name,
                          @RequestParam(required = false, defaultValue ="")  String dateAndTime,
                          @RequestParam(required = false, defaultValue ="")  String codeWord,
                          @RequestParam(required = false, defaultValue ="")  String phoneNumber,
                          @RequestParam int countOfPeoples,
                          Model model){

        if(restaurantService.addBook(id,name,dateAndTime,codeWord,phoneNumber,countOfPeoples)) {
            return "redirect:/restaurant";
        }else{
            model.addAttribute("message","Данные введены не корректно");
            model.addAttribute("restaurant",restaurantService.findById(id));
            return "restaurantBook";
        }
    }
}
