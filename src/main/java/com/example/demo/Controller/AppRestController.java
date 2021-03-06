package com.example.demo.Controller;

import com.example.demo.Model.Music;
import com.example.demo.Service.AppService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class AppRestController {
    private final AppService appService;

    @Autowired
    private UserService us;

    public AppRestController(AppService appService) {
        this.appService = appService;
    }


//    @PostMapping("/play/{music_name}/{time}/{groupid}")
//    public Object postMusic() throws IOException {
//        //appService.startClient();
//        return "index";
//    }

    @GetMapping("/sync")
    public Object syncTrack(@RequestParam String userid) throws IOException {
        System.out.println("id: " + userid);
        return appService.syncTrack(userid);
    }
    @PostMapping("/syncU")
    public void sendTrack(@ModelAttribute Music m, @RequestParam String groupid) throws IOException {
        //+System.out.println(m);
        appService.sendTrack(m.getPath(), m.getTime_stamp(),m.getPitch(), Integer.valueOf(groupid));
    }

    @GetMapping("/openServerSocket")
    public void openServerSocket() throws IOException {
        appService.openServerSocket();
    }

}
