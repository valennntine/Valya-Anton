package com.example.JB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {


    @GetMapping("/")
    public String greeting(Model model)  {
        model.addAttribute("cafe1", "76d0b2f8-e536-4431-ae73-3126f28dedae.LE0TDWEY605peLRKwOzSGA-wide.jpg");
        model.addAttribute("cafe2", "05bee522-25df-4d7f-bfe1-9ff31835d733.fd2fa54ed6aceb4bf03436a0c87352af.jpeg");
        model.addAttribute("cafe3", "602b1dfd-7788-40f3-a299-e2f0465553a6.c20a8abe26baab12d66e05d7d5665ae2.jpg");
         return "greeting";
    }
}
