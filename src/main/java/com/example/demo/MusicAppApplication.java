package com.example.demo;

import com.example.demo.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MusicAppApplication {


    public static void main(String[] args) throws IOException {
        AppService.openServerSocket();
        SpringApplication.run(MusicAppApplication.class, args);

    }

}
