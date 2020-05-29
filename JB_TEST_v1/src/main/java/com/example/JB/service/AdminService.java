//package com.example.JB.service;
//
//import com.example.JB.dao.AdminDao;
//import com.example.JB.model.Admin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AdminService {
//
//    private AdminDao adminDao;
//
//    @Autowired
//    public AdminService(@Qualifier("fakeDao") AdminDao adminDao) {
//        this.adminDao = adminDao;
//    }
//
//
//    public int addAdmin(Admin admin){
//        return  adminDao.insertAdmin(admin);
//    }
//
//    public List<Admin> getAllAdmins(){
//        return adminDao.selectAllAdmin();
//    }
//}
