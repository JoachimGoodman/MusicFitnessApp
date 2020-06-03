package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContentController {
    @GetMapping("/content")
    public String getContent(@RequestParam("content") String content ) {
        return "content/" + content;
    }
}