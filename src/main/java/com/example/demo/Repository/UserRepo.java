package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    //User findByUsername(String username);
    List<User> findAll();

}
