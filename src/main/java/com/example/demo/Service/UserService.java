package com.example.demo.Service;


import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo ur;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService() throws IOException {
    }

    public void findAll(){
        System.out.println(ur.findAll());
    }
    public User getSingle(String username){
        return ur.findByUsername(username);
    }

    public void createUser(User user) {
        ur.logUser(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()), true, user.getFirstname(), user.getLastname(), user.getEmail());
        ur.logPermission(user.getUsername(), "ROLE_BRUGER");
    }



}
