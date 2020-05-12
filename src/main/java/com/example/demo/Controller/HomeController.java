package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() throws IOException {
        return "index";
    }

    @GetMapping("/play")
    public String video() {return "video";} // test

}
