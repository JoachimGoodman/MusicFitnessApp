package com.example.demo.Service;

import com.example.demo.Model.Music;
import com.example.demo.Repository.AppRepository;
import com.example.demo.Repository.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {


    @Autowired
    private MusicRepo mr;

    public List<Music> getAllMusic() {
        return mr.findAll();
    }
}
