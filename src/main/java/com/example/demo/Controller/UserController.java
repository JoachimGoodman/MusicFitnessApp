package com.example.demo.Controller;

import com.example.demo.Model.Group;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

//Controller til Login. Vores login front og backend er allerede serveret af Springs security starter.
@Controller
public class UserController {

  @Autowired
  UserService us;

  @Autowired
  AppService as;

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
        session.setAttribute("currentuser",username);
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
          model.addAttribute("group",new Group());
          model.addAttribute("groups",us.getSingle(username).getGroups());
          return "content/groups";
      }

    @PostMapping("/joinGroup/{groupid}/{userid}")
    public String joinGroup(HttpSession session, @PathVariable String groupid, @PathVariable String userid) throws IOException {
        System.out.println(userid);
        as.joinGroup(groupid, userid);
        session.setAttribute("currentgroup",groupid);
        return "redirect:/";
    }

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
