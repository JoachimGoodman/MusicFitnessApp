package com.example.demo.Controller;

import com.example.demo.Model.Music;
import com.example.demo.Service.AppService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/getMusic")
    public Object getMusic() throws IOException {
        appService.startClient();
        return null;
    }

    @PostMapping("/play/{music_name}/{time}/{groupid}")
    public Object postMusic() throws IOException {
        //appService.startClient();
        return "index";
    }

    @GetMapping("/sync")
    public Object sync() throws IOException {
        return appService.waitForHost();

    }

    @PostMapping("/syncU")
    public void sendTrack(@ModelAttribute Music m) throws IOException {
        appService.sendTrack(m.getPath(),m.getTime_stamp());

    }

    @GetMapping("/openServerSocket")
    public void openServerSocket() throws IOException {
        appService.openServerSocket();

    }
}
