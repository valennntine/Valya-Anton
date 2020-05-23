//package com.example.JB.dao;
//
//import com.example.JB.model.Admin;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Repository("fakeDao")
//public class FakeAdminDataAccessService implements AdminDao{
//    private static List<Admin> DB = new ArrayList<>();
//
//
//    @Override
//    public int insertAdmin(UUID id, Admin admin) {
//        DB.add(new Admin(id,admin.getEmail(),admin.getPassword()));
//        return 1;
//    }
//
//    @Override
//    public List<Admin> selectAllAdmin() {
//        return DB;
//    }
//
//
//}
