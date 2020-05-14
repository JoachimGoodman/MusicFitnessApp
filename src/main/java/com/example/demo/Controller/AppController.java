package com.example.demo.Controller;

import com.example.demo.Model.Music;
import com.example.demo.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@RestController
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/getMusic")
    public Object getMusic() throws IOException {
        appService.startClient("1","1");
        return null;
    }
    @GetMapping("/joinGroup/{id}")
    public Object joinGroup(@PathVariable String id,@RequestParam String userid) throws IOException {
        System.out.println(userid);
        appService.startClient(id,userid);
        return null;
    }

    @PostMapping("/play/{music_name}/{time}/{groupid}")
    public Object postMusic() throws IOException {
        //appService.startClient();
        return "index";
    }

    @GetMapping("/sync")
    public Object sync(@RequestParam String userid) throws IOException {
        System.out.println("id: "+userid);
        return appService.waitForHost(userid);

    }
    @PostMapping("/syncU")
    public void sendTrack(@ModelAttribute Music m,@RequestParam String groupid) throws IOException {
        appService.sendTrack(m.getPath(),m.getTime_stamp(),Integer.valueOf(groupid));

    }

    @GetMapping("/openServerSocket")
    public void openServerSocket() throws IOException {
        appService.openServerSocket();

    }
}
