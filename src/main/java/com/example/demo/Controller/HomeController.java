package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session) throws IOException {
        return "index";
    }

    @GetMapping("/play")
    public String video() {return "video";} // test

}
