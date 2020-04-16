package com.example.demo.Controller;

import com.example.demo.Service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
