//package com.example.JB.api;
//
//import com.example.JB.model.Admin;
//import com.example.JB.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequestMapping("api/v1/admin")
//@RestController
//public class AdminController {
//    private AdminService adminService;
//
//    @Autowired
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    @PostMapping
//    public void addAdmin(@RequestBody Admin admin){
//        adminService.addAdmin(admin);
//    }
//
//    @GetMapping
//    public List<Admin> getAllAdmins (){
//        return adminService.getAllAdmins();
//    }
//}
