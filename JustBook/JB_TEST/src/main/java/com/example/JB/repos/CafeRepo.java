package com.example.JB.repos;

import com.example.JB.model.Cafe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CafeDao")
public interface CafeRepo extends CrudRepository<Cafe,Long> {


    Cafe findByName(String name);
}
