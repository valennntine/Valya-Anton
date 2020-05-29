//package com.example.JB.dao;
//
//import com.example.JB.model.Admin;
//
//import java.util.List;
//import java.util.UUID;
//
//public interface AdminDao {
//
//    int insertAdmin(UUID id, Admin admin);
//
//    default int insertAdmin(Admin admin){
//        UUID id = UUID.randomUUID();
//        return insertAdmin(id,admin);
//    }
//
//    List<Admin> selectAllAdmin();
//}