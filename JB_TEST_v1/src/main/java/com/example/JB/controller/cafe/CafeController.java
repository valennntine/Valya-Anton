package com.example.JB.controller.cafe;


import com.example.JB.model.Cafe;
import com.example.JB.service.CafeService;
import com.example.JB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/cafe")
public class CafeController {


    @Autowired
    private CafeService cafeService;

    @Autowired
    private UserService userService;





    @GetMapping
    public String main( Map<String, Object> model){
        Iterable<Cafe> cafes = cafeService.findAll();
        String userRole = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).isAdmin();
        model.put("userRole",userRole);
        model.put("cafes", cafes);

        return "cafe";
    }


    @GetMapping("find")
    public String find(@RequestParam(required = false, defaultValue ="")  String name, Model model){ // переписать

        model.addAttribute("cafes", cafeService.findByName(name));
        model.addAttribute("userRole", userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).isAdmin());
        model.addAttribute("name", name);


        return "cafe";
    }




    @GetMapping("del")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String delete( @RequestParam("cafeId") Cafe cafe, Model model){
        cafeService.delete(cafe);

        Iterable<Cafe> cafes = cafeService.findAll();
        String userRole = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).isAdmin();
        model.addAttribute("userRole",userRole);
        model.addAttribute("cafes", cafes);
        return "cafe";
    }

    @GetMapping("{cafe}")
    public String cafeEditForm(@PathVariable Cafe cafe, Model model){
        model.addAttribute("cafe", cafe);
        return "cafeEdit";
    }

    @PostMapping("update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String cafeSave(
            @RequestParam String name,
            @RequestParam String text,
            @RequestParam String description,
            @RequestParam String phone,
            @RequestParam String googleMap,
            @RequestParam("cafeId") Cafe cafe
    ){
        cafeService.update(cafe,name,text,description,phone,googleMap);
        return "redirect:/cafe";
    }

}



