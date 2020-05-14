package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.AppService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class LoginController {

  @Autowired
  UserService us;
/*
    @GetMapping("/login")
    public String login(Model model){
        us.findAll();
        //model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String Confirmlogin(@ModelAttribute User user){
        us.findAll();

        return "index";
    }
    */


}
