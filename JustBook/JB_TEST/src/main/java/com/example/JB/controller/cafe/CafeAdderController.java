package com.example.JB.controller.cafe;

import com.example.JB.model.Cafe;
import com.example.JB.service.CafeService;
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
@RequestMapping("/cafe/adder")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CafeAdderController {

    @Autowired
    private CafeService cafeService;

    @Value("${upload.path}")
    private String uploadPath;



    @GetMapping
    public String main(){
        return "cafeAdder";
    }

    @PostMapping("add")
    public String add(@RequestParam("file") MultipartFile file,
                      @RequestParam(required = false, defaultValue ="") String name ,
                      @RequestParam (required = false, defaultValue ="") String text,
                      @RequestParam (required = false, defaultValue ="") String description,
                      @RequestParam (required = false, defaultValue ="") String phone,
                      @RequestParam (required = false, defaultValue ="") String map,
                                  Map<String, Object> model) throws IOException {
        cafeService.addCafe(uploadPath,file,name,text,description,phone,map);

        Iterable<Cafe> cafes = cafeService.findAll();
        model.put("cafes", cafes);
        return "redirect:/cafe";
    }
}
