package com.example.demo.Service;


import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo ur;

    public UserService() throws IOException {
    }

    public void findAll(){
        System.out.println(ur.findAll());

    }


}
