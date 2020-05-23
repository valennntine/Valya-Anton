package com.example.JB.controller.cafe;


import com.example.JB.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cafe/{name}")
public class CafePageController {

    @Autowired
    CafeService cafeService;

    @GetMapping("page")
    public String main(
            @PathVariable("name") String name,
            Model model){
        model.addAttribute("cafe", cafeService.find(name));
        return "cafePage";
    }




}
