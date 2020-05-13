package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
}
