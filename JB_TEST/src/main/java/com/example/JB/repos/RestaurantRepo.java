package com.example.JB.repos;

import com.example.JB.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("RestaurantDao")
public interface RestaurantRepo extends CrudRepository<Restaurant,Long> {

    Restaurant findByName(String name);

    Restaurant findById(long id);
}
