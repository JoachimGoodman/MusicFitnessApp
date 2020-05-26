package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.AppService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//Controller til Login. Vores login front og backend er allerede serveret af Springs security starter.
@Controller
public class LoginController {

  @Autowired
  UserService us;

      @GetMapping("/session")
      public String createsession(HttpSession session){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
           username = ((UserDetails)principal).getUsername();
        } else {
           username = principal.toString();
        }
        System.out.println(username);
        return "redirect:/";
      }
      @GetMapping("/getGroups")
      public String getGroups(Model model){
          Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          String username;
          if (principal instanceof UserDetails) {
              username = ((UserDetails)principal).getUsername();
          } else {
              username = principal.toString();
          }
          System.out.println(username);
          model.addAttribute("user",us.getSingle(username).getGroups());
          return "groups";
      }

//    @GetMapping("/login")
//    public String login(Model model){
//        us.findAll();
//        //model.addAttribute("user", new User());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String Confirmlogin(@ModelAttribute User user){
//        us.findAll();
//
//        return "index";
//    }

}
