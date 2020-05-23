package com.example.JB.repos;

import com.example.JB.model.Book;
import com.example.JB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);

    List<Book> findAllById(long id);
}
