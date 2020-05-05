package com.example.demo.Controller;

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
    public Object getMusic() {
        return appService.getAllMusic();
    }

    @PostMapping("/play/{music_name}/{time}/{groupid}")
    public Object postMusic() throws IOException {
        appService.startClient();
        return "index";
    }

    @GetMapping("/sync")
    public Object sync() throws IOException {
        return appService.waitForHost();

    }

    @PostMapping("/sync/")
    public void sendTrack(@PathVariable("path") String path,@PathVariable("time") String time) throws IOException {
        appService.sendTrack(path,time);

    }

    @GetMapping("/openServerSocket")
    public void openServerSocket() throws IOException {
        appService.openServerSocket();

    }
}
