package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    UserService us;

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    @PostMapping("/register")
    public String registerSend(@ModelAttribute User user){
        us.createUser(user);
        //System.out.println(user);

        return  "redirect:/";
    }
}
