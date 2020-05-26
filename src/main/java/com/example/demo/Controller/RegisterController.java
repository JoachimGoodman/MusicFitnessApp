package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//Controller til registering af nye brugere. Her er en simpel get og post mapping.
//data fra frontend bliver lagt i et object og sent videre til UserService.
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
